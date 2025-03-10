import org.jetbrains.kotlinx.lincheck.RandomProvider
import org.jetbrains.kotlinx.lincheck.paramgen.ParameterGenerator
import software.amazon.s3.analyticsaccelerator.util.ObjectKey
import software.amazon.s3.analyticsaccelerator.util.S3URI

class ObjectKeyGen(randomProvider: RandomProvider, configuration: String) : ParameterGenerator<ObjectKey?> {
    private val random = randomProvider
    private val config = configuration

    val bucket: String = "fbbasik-pp-test"
    val key: String = "0001_part_00.parquet"
    val etag: String = "aba9aa002aee2e8fe5cf5f322cfc93c0"


    override fun generate(): ObjectKey {
        return ObjectKey(S3URI.of(bucket, key), etag)
    }

    override fun reset() {
    }
}