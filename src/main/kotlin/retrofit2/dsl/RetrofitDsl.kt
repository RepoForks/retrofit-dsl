/*
 * Copyright (c) 2018 Piruin Panichphol
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package retrofit2.dsl

import retrofit2.Retrofit
import retrofit2.dsl.paging.PagingAdapter

inline fun retrofit(block: Retrofit.Builder.() -> Unit): Retrofit {
    return Retrofit.Builder().apply(block).build()!!
}

inline fun <reified T> retrofitFor(block: Retrofit.Builder.() -> Unit): T {
    return retrofit(block).create()
}

inline fun <reified T> Retrofit.create(): T {
    return create(T::class.java)
}

inline fun <reified T> Retrofit.converterFor(
    annotations: Array<out Annotation> = arrayOf()
) = responseBodyConverter<T>(T::class.java, annotations)

class RetrofitDslConfig {
    companion object {
        var retrofit: Retrofit? = null
        var pagingAdapter: PagingAdapter? = null
    }
}
