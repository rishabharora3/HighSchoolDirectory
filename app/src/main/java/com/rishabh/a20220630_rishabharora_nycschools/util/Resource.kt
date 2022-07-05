package com.rishabh.a20220630_rishabharora_nycschools.util

/**
 *  Helpful utility functions that are strictly related to networking responses.
 */
class Resource<out T>(val status: Status, val data: T?, val error: Error?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(error: Error? = null, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, error)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}