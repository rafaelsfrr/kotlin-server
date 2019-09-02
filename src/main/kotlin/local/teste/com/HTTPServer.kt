package local.teste.com

import io.undertow.Undertow
import local.teste.com.api.TesteApplication
import org.apache.log4j.Logger
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer
import org.jboss.resteasy.spi.ResteasyDeployment

class HTTPServer {
    companion object {

        val logger: Logger = Logger.getLogger(HTTPServer::class.java.name)

        fun start() {

            try {

                val port = 8080
                logger.info("Inicializando servidor na porta $port")

                val server = UndertowJaxrsServer()
                val serverBuilder = Undertow.builder().addHttpListener(port, "0.0.0.0")
                server.start(serverBuilder)

                val deployment = ResteasyDeployment()
                deployment.applicationClass = TesteApplication::class.java.name

                val deploymentInfo = server.undertowDeployment(deployment)
                    .setClassLoader(HTTPServer::class.java.classLoader)
                    .setContextPath("/teste")
                    .setDeploymentName("Teste")

                server.deploy(deploymentInfo)
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }
}