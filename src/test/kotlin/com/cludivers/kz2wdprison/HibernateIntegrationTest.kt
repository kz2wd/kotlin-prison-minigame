package com.cludivers.kz2wdprison

import com.cludivers.kz2wdprison.framework.beans.PlayerBean
import com.cludivers.kz2wdprison.framework.beans.nation.*
import org.junit.jupiter.api.Test

class HibernateIntegrationTest {

    @Test
    fun hibernateBuildTest(){

        val classes = listOf(PlayerBean::class.java, AreaPermissionBean::class.java, ChunkBean::class.java,
            NationBean::class.java, NationPermission::class.java, NationPlot::class.java, PermissionGroup::class.java)
        LocalDatabase.loadAndBuildDB(classes)

    }
}