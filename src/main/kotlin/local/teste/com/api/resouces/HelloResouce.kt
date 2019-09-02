package local.teste.com.api.resouces

import local.teste.com.api.ws.Hello
import org.apache.log4j.Logger
import javax.servlet.http.HttpServletRequest
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/api/hello")
class HelloResouce {

    val logger = Logger.getLogger(HelloResouce::class.java.name)

    @GET
    @Path("/world")
    @Produces(MediaType.APPLICATION_JSON)
    fun helloWorld(@Context req: HttpServletRequest): Response {
        logger.info("GET /hello/world ${req.remoteHost}")

        val user = Hello("world")

        return Response.ok().entity(user).build()
    }

}