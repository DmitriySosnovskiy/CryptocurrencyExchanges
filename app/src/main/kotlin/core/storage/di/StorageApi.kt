package core.storage.di

import core.storage.PersistentStorage

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
interface StorageApi {
    val persistentStorage: PersistentStorage
}