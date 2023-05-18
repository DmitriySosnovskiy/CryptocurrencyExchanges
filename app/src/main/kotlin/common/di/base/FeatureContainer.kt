package common.di.base

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 16.05.2023
 */
interface FeaturesContainer {
    fun <T : Any> getFeature(key: Class<T>): T

    fun init(features: Map<Class<*>, FeatureHolder<*>>)
}

class FeaturesContainerImpl : FeaturesContainer {

    private val featureHolders: MutableMap<Class<*>, FeatureHolder<*>> = mutableMapOf()

    override fun init(features: Map<Class<*>, FeatureHolder<*>>) {
        featureHolders.putAll(features)
    }

    override fun <T : Any> getFeature(key: Class<T>): T {
        return getFeatureHolder(key).getFeature()
    }

    private fun <T : Any> getFeatureHolder(key: Class<T>): FeatureHolder<T> {
        return retrieveFeatureHolder(key) ?: throw IllegalStateException("Failed to get feature $key")
    }

    private fun <T : Any> retrieveFeatureHolder(key: Class<T>): FeatureHolder<T>? {
        return featureHolders[key] as? FeatureHolder<T>
    }
}