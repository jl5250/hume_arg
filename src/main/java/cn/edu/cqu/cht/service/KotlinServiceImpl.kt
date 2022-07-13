package cn.edu.cqu.cht.service

import cn.edu.cqu.cht.mapper.KotlinMapper
import cn.edu.cqu.cht.model.Kotlin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *
 * @author WJL
 * @since 2022/5/31
 */
@Service
class KotlinServiceImpl(@Autowired private val kotlinMapper: KotlinMapper) : KotlinService {

    override fun findById(id: Long): Kotlin {
        return kotlinMapper.selectById(id)
    }
}