package common.di.base

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 16.05.2023
 */
abstract class FeatureHolder<T>(private val featuresContainer: FeaturesContainer) {
    /**
     * Экземпляр Api фичи
     */
    private var buildedFeature: T? = null

    /**
     * Lock, под которым выполняется создание фичи
     */
    private val mBuildFeatureLock: Lock = ReentrantLock()

    fun getFeature(): T {
        return buildedFeature ?: let {
            mBuildFeatureLock.lock()
            val buildedFeature = buildedFeature ?: run {
                buildFeature().also { buildedFeature = it }
            }
            mBuildFeatureLock.unlock()

            return@let buildedFeature
        }
    }

    /**
     * Создает фичу подставляя используя необходимые зависимости
     */
    protected abstract fun buildFeature(): T

    protected fun <D : Any> getDependency(key: Class<D>): D {
        return featuresContainer.getFeature(key)
    }
}