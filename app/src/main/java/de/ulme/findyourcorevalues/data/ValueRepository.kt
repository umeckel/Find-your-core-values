package de.ulme.findyourcorevalues.data

import kotlin.streams.toList

interface ValueRepository {
    fun getAll(): List<CoreValue>
}


class DummyValueRepository : ValueRepository {
    override fun getAll(): List<CoreValue> {
        return CoreValues.DEFAULT_VALUES.stream()
            .map { CoreValue(it) }
            .toList()
    }

}