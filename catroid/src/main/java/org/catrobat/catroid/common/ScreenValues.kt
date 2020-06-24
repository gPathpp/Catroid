/*
 * Catroid: An on-device visual programming system for Android devices
 * Copyright (C) 2010-2018 The Catrobat Team
 * (<http://developer.catrobat.org/credits>)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * An additional term exception under section 7 of the GNU Affero
 * General Public License, version 3, is available at
 * http://developer.catrobat.org/license_additional_term
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.catrobat.catroid.common

import android.content.Context
import org.catrobat.catroid.content.Project
import org.catrobat.catroid.utils.ScreenValueHandler

class ScreenValues(context: Context, currentProject: Project) {
    var resizePossible = false
        private set
    var maxViewPortX = 0
    var maxViewPortY = 0
    var maxViewPortHeight = 0
    var maxViewPortWidth = 0

    fun getScreenHeightForProject(project: Project): Int {
        return if (project.isCastProject) {
            CAST_SCREEN_HEIGHT
        } else SCREEN_HEIGHT
    }

    fun getScreenWidthForProject(project: Project): Int {
        return if (project.isCastProject) {
            CAST_SCREEN_WIDTH
        } else SCREEN_WIDTH
    }

    init {
        ScreenValueHandler.updateScreenWidthAndHeight(context)
        val virtualScreenWidth = currentProject.xmlHeader.virtualScreenWidth
        val virtualScreenHeight = currentProject.xmlHeader.virtualScreenHeight

        if (virtualScreenHeight > virtualScreenWidth && isInLandscapeMode()
            || virtualScreenHeight < virtualScreenWidth && isInPortraitMode()) {
            swapWidthAndHeigth()
        }

        val virtualAspectRatio = virtualScreenWidth.toFloat() / virtualScreenHeight.toFloat()
        val ratioHeight = SCREEN_HEIGHT.toFloat() / virtualScreenHeight.toFloat()
        val ratioWidth = SCREEN_WIDTH.toFloat() / virtualScreenWidth.toFloat()

        initMaxViewPort(virtualAspectRatio, currentProject, ratioHeight, ratioWidth)
    }

    private fun initMaxViewPort(virtualAspectRatio: Float, currentProject: Project, ratioHeight: Float, ratioWidth: Float) {
        if (aspectRatio.compareTo(virtualAspectRatio) == 0 || currentProject.isCastProject) {
            maxViewPortWidth = SCREEN_WIDTH
            maxViewPortHeight = SCREEN_HEIGHT
            resizePossible = false
        } else if (virtualAspectRatio < aspectRatio) {
            val scale = ratioHeight / ratioWidth
            maxViewPortWidth = (SCREEN_WIDTH * scale).toInt()
            maxViewPortX = ((SCREEN_WIDTH - maxViewPortWidth) / 2f).toInt()
            maxViewPortHeight = SCREEN_HEIGHT
            resizePossible = true
        } else {
            val scale = ratioWidth / ratioHeight
            maxViewPortHeight = (SCREEN_HEIGHT * scale).toInt()
            maxViewPortY = ((SCREEN_HEIGHT - maxViewPortHeight) / 2f).toInt()
            maxViewPortWidth = SCREEN_WIDTH
            resizePossible = true
        }
    }

    companion object {
        const val CAST_SCREEN_WIDTH = 1280
        const val CAST_SCREEN_HEIGHT = 720
        private const val DEFAULT_SCREEN_HEIGHT = 768
        private const val DEFAULT_SCREEN_WIDTH = 1280
        var SCREEN_WIDTH = 0
        var SCREEN_HEIGHT = 0

        fun setToDefaultScreenSize() {
            SCREEN_WIDTH = DEFAULT_SCREEN_WIDTH
            SCREEN_HEIGHT = DEFAULT_SCREEN_HEIGHT
        }

        fun setToLandscapeMode() {
            if (isInPortraitMode()) {
                swapWidthAndHeigth()
            }
        }

        fun setToPortraitMode() {
            if (isInLandscapeMode()) {
                swapWidthAndHeigth()
            }
        }

        val aspectRatio: Float
            get() {
                if (SCREEN_WIDTH == 0 || SCREEN_HEIGHT == 0) {
                    setToDefaultScreenSize()
                }
                return SCREEN_WIDTH.toFloat() / SCREEN_HEIGHT.toFloat()
            }

        private fun isInPortraitMode(): Boolean = SCREEN_WIDTH < SCREEN_HEIGHT

        private fun isInLandscapeMode(): Boolean = !isInPortraitMode()

        private fun swapWidthAndHeigth() {
            val tmp = SCREEN_HEIGHT
            SCREEN_HEIGHT = SCREEN_WIDTH
            SCREEN_WIDTH = tmp
        }
    }
}