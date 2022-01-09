package com.gabriel.easy_eat_recipe.util

/**
 * Sealed Network Result class that has generic <T> takes in 2 parameters
 * This sealed class doesn't necessarily have to have these two parameters, it can be empty
 * First parameter being for the data of type T, which can be null
 * Second parameter being the message of type String which can be null too
 * Classes defined within this sealed class can inherit this NetworkResult sealed class
 */
sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {
    /**
     * This Success class that has generic <T> inherits the sealed NetworkResult class
     * The Success class has one parameter 'data' of type T
     * The parameter 'data' of type T is passed on to the inherited NetworkResult class
     * which accepts the type T
     */
    class Success<T>(data: T) : NetworkResult<T>(data)

    /**
     * This Error class that has generic <T> inherits the sealed NetworkResult class
     * The Error class has two parameters; 'data' of type T and message of type String
     * The parameter 'data' of type T and the parameter of type String
     * are passed on to the inherited NetworkResult class
     * which accepts the type T and the type String
     */
    class Error<T>(message: String?, data: T? = null) : NetworkResult<T>(data, message)

    /**
     * This Loading class that has generic <T> inherits the sealed NetworkResult class
     * The Error class has no parameters;
     * Nothing is passed on to the inherited NetworkResult class
     * which is fine because the two parameters in the inherited NetworkResult can both be null
     */
    class Loading<T>: NetworkResult<T>()
}