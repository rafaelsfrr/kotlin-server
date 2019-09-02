package local.teste.com.api

import local.teste.com.api.resouces.HelloResouce
import org.apache.log4j.Logger
import javax.ws.rs.core.Application
import kotlin.math.log


class TesteApplication: Application() {

    val logger = Logger.getLogger(TesteApplication::class.java.name)
    val singletons: HashSet<Any> = HashSet()

    init {
        logger.info("Adicionando resources no mapa")
        singletons.add(HelloResouce())
    }

    override fun getClasses(): MutableSet<Class<*>> {
        val resources: MutableSet<Class<*>> = HashSet()
        return resources
    }

    override fun getSingletons(): MutableSet<Any> {
        return singletons
    }
}