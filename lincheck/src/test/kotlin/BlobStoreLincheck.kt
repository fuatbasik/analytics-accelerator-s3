import org.jetbrains.kotlinx.lincheck.annotations.Operation
import org.jetbrains.kotlinx.lincheck.annotations.Param
import org.jetbrains.kotlinx.lincheck.check
import org.jetbrains.kotlinx.lincheck.strategy.managed.modelchecking.ModelCheckingOptions
import org.jetbrains.kotlinx.lincheck.strategy.stress.StressOptions
import org.junit.jupiter.api.Test
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.S3AsyncClient
import software.amazon.s3.analyticsaccelerator.S3SdkObjectClient
import software.amazon.s3.analyticsaccelerator.common.telemetry.Telemetry
import software.amazon.s3.analyticsaccelerator.io.physical.PhysicalIOConfiguration
import software.amazon.s3.analyticsaccelerator.io.physical.data.BlobStore
import software.amazon.s3.analyticsaccelerator.request.ObjectMetadata
import software.amazon.s3.analyticsaccelerator.request.StreamContext
import software.amazon.s3.analyticsaccelerator.util.ObjectKey


@Param(name = "key", gen = ObjectKeyGen::class, conf = "key=10")
@Param(name = "metadata", gen = ObjectMetadataGen::class, conf = "metadata=10")
@Param(name = "streamContext", gen = StreamContextGen::class, conf = "streamContext=10")
class BlobStoreLincheck {
    private val asyncClient: S3AsyncClient = S3AsyncClient.builder().region(Region.US_EAST_1).build()
    private val client: S3SdkObjectClient = S3SdkObjectClient(asyncClient)
    private val blobStore = BlobStore(client, Telemetry.NOOP, PhysicalIOConfiguration.DEFAULT)

    @Operation
    fun getObject(@Param (gen = ObjectKeyGen::class, conf = "key=10")  key: ObjectKey,
                  @Param (gen = ObjectMetadataGen::class, conf = "metadata=10") metadata: ObjectMetadata,
                  @Param (gen = StreamContextGen::class, conf = "streamContext=10") streamContext: StreamContext
    )
            = blobStore.get(key, metadata, streamContext).read(0);


//    @Operation
//    fun evict(@Param (gen = ObjectKeyGen::class, conf = "key=10") key: ObjectKey) = blobStore.evictKey(key);

    @Operation
    fun size() = blobStore.blobCount();
//
//
//    @Test // Run the test
//    fun stressTest() = StressOptions().check(this::class)
//
    @Test
    fun modelCheckingTest() = ModelCheckingOptions().invocationsPerIteration(1).iterations(100).threads(2)
    .check(this::class)
}