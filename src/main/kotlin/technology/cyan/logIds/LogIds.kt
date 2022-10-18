package technology.cyan.logIds

import kotlin.reflect.full.memberProperties

class LogIds {
    companion object {
        inline fun <reified T : Any> toIdsMap(instance: T): Map<String, String> {
            return T::class.memberProperties.filter {
                it.name.matches(Regex(".*[iI]d$"))
            }.associate { it.name to it.get(instance)?.toString().orEmpty() }
        }
    }
}