import org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage
import org.junit.platform.engine.support.descriptor.EngineDescriptor
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder
import org.junit.platform.launcher.core.LauncherFactory
import org.junit.platform.launcher.listeners.SummaryGeneratingListener

fun main() {
    val request = LauncherDiscoveryRequestBuilder.request()
        .selectors(selectPackage("com.slavix.banking"))
        .build()

    val launcher = LauncherFactory.create()

    val testPlan = launcher.discover(request)

    val summaryListener = SummaryGeneratingListener()

    launcher.registerTestExecutionListeners(summaryListener)

    launcher.execute(request)

    val summary = summaryListener.summary

    println("Tests run: ${summary.testsFoundCount}")
    println("Tests succeeded: ${summary.testsSucceededCount}")
    println("Tests failed: ${summary.testsFailedCount}")
}