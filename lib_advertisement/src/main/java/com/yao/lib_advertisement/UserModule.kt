package com.yao.lib_advertisement

import com.yao.lib_advertisement.UserDaggerServiceImpl
import com.yao.lib_base.UserDaggerService
import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @Provides
    fun providerUserDaggerService(): UserDaggerService {
        return UserDaggerServiceImpl()
    }
}