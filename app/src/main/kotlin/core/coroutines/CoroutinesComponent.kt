package core.coroutines

import dagger.Component
import javax.inject.Singleton

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
@Component(modules = [DispatchersModule::class])
@Singleton
interface CoroutinesComponent : CoroutinesApi