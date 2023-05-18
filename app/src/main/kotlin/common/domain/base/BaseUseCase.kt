package common.domain.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
abstract class BaseUseCase<in P, out R>(
    private val dispatcher: CoroutineDispatcher,
) {

    suspend operator fun invoke(arg: P): Result<R> {
        return try {
            withContext(dispatcher) {
                execute(arg).let {
                    Result.success(it)
                }
            }
        } catch (throwable: Throwable) {
            Result.failure(throwable)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(arg: P): R
}

/**
 * Для случая, когда не требуется аргумент в UseCase
 */
suspend fun <R> BaseUseCase<Unit, R>.invoke(): Result<R> = invoke(Unit)