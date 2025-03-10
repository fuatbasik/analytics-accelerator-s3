import org.jetbrains.kotlinx.lincheck.RandomProvider
import org.jetbrains.kotlinx.lincheck.paramgen.ParameterGenerator
import software.amazon.s3.analyticsaccelerator.request.GetRequest
import software.amazon.s3.analyticsaccelerator.request.StreamContext


class StreamContextGen(randomProvider: RandomProvider, configuration: String) : ParameterGenerator<StreamContext?> {

    private val random = randomProvider
    private val config = configuration

    override fun generate(): StreamContext {
        return DummyStreamContext();
    }

    override fun reset() {
    }
}

class DummyStreamContext : StreamContext {

    override fun modifyAndBuildReferrerHeader(getRequestContext: GetRequest?): String {
        return "LincheckTest";
    }
}