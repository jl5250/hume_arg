package cn.edu.cqu.cht.mapper

import cn.edu.cqu.cht.model.Kotlin

/**
 *
 * @author WJL
 * @since 2022/5/31
 */
interface KotlinMapper {
    fun selectById(id: Long):Kotlin
}