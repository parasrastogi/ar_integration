package com.app.homeViewer

import com.google.ar.core.Config
import com.google.ar.core.Session
import com.google.ar.sceneform.ux.ArFragment

class HorizontalPlaneArFragment : ArFragment() {

    var session: Session? = null

    override fun getSessionConfiguration(session: Session?): Config {
        this.session = session

        val config = Config(session)
        config.planeFindingMode = Config.PlaneFindingMode.HORIZONTAL
        return config
    }
}