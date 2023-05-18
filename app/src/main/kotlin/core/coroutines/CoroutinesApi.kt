package core.coroutines

import javax.inject.Qualifier
import kotlinx.coroutines.CoroutineDispatcher

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
interface CoroutinesApi {
    val ioDispatcher: CoroutineDispatcher
}