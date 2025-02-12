package br.com.vitor.forum.mapper

interface Mapper<T, U> {
    fun map(dto: T): U
}
