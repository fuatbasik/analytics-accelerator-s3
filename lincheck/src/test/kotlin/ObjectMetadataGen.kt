import org.jetbrains.kotlinx.lincheck.RandomProvider
import org.jetbrains.kotlinx.lincheck.paramgen.ParameterGenerator
import software.amazon.s3.analyticsaccelerator.request.ObjectMetadata


class ObjectMetadataGen(randomProvider: RandomProvider, configuration: String) : ParameterGenerator<ObjectMetadata?> {
    private val random = randomProvider
    private val config = configuration
    val etag: String = "298a173880ff39443d9a115e7c2a87e1-9"


    override fun generate(): ObjectMetadata {
        return  ObjectMetadata.builder().contentLength(1400000).etag(etag).build()
    }

    override fun reset() {
    }
}