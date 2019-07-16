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

package org.catrobat.catroid.test.content.bricks;

import com.badlogic.gdx.scenes.scene2d.Action;

import org.catrobat.catroid.ProjectManager;
import org.catrobat.catroid.common.BrickValues;
import org.catrobat.catroid.content.Project;
import org.catrobat.catroid.content.Sprite;
import org.catrobat.catroid.content.actions.AddItemToUserListAction;
import org.catrobat.catroid.content.actions.ArduinoSendDigitalValueAction;
import org.catrobat.catroid.content.actions.ArduinoSendPWMValueAction;
import org.catrobat.catroid.content.actions.AskAction;
import org.catrobat.catroid.content.actions.AskSpeechAction;
import org.catrobat.catroid.content.actions.AssertEqualsAction;
import org.catrobat.catroid.content.actions.CameraBrickAction;
import org.catrobat.catroid.content.actions.ChangeBrightnessByNAction;
import org.catrobat.catroid.content.actions.ChangeColorByNAction;
import org.catrobat.catroid.content.actions.ChangeSizeByNAction;
import org.catrobat.catroid.content.actions.ChangeTransparencyByNAction;
import org.catrobat.catroid.content.actions.ChangeVariableAction;
import org.catrobat.catroid.content.actions.ChangeVolumeByNAction;
import org.catrobat.catroid.content.actions.ChangeXByNAction;
import org.catrobat.catroid.content.actions.ChangeYByNAction;
import org.catrobat.catroid.content.actions.ChooseCameraAction;
import org.catrobat.catroid.content.actions.ClearBackgroundAction;
import org.catrobat.catroid.content.actions.ClearGraphicEffectAction;
import org.catrobat.catroid.content.actions.CloneAction;
import org.catrobat.catroid.content.actions.ComeToFrontAction;
import org.catrobat.catroid.content.actions.DeleteItemOfUserListAction;
import org.catrobat.catroid.content.actions.DeleteThisCloneAction;
import org.catrobat.catroid.content.actions.DroneEmergencyAction;
import org.catrobat.catroid.content.actions.DroneFlipAction;
import org.catrobat.catroid.content.actions.DroneMoveBackwardAction;
import org.catrobat.catroid.content.actions.DroneMoveDownAction;
import org.catrobat.catroid.content.actions.DroneMoveForwardAction;
import org.catrobat.catroid.content.actions.DroneMoveLeftAction;
import org.catrobat.catroid.content.actions.DroneMoveRightAction;
import org.catrobat.catroid.content.actions.DroneMoveUpAction;
import org.catrobat.catroid.content.actions.DronePlayLedAnimationAction;
import org.catrobat.catroid.content.actions.DroneSwitchCameraAction;
import org.catrobat.catroid.content.actions.DroneTakeoffAndLandAction;
import org.catrobat.catroid.content.actions.DroneTurnLeftAction;
import org.catrobat.catroid.content.actions.DroneTurnRightAction;
import org.catrobat.catroid.content.actions.EventAction;
import org.catrobat.catroid.content.actions.FlashAction;
import org.catrobat.catroid.content.actions.GoNStepsBackAction;
import org.catrobat.catroid.content.actions.GoToOtherSpritePositionAction;
import org.catrobat.catroid.content.actions.GoToRandomPositionAction;
import org.catrobat.catroid.content.actions.GoToTouchPositionAction;
import org.catrobat.catroid.content.actions.HideTextAction;
import org.catrobat.catroid.content.actions.InsertItemIntoUserListAction;
import org.catrobat.catroid.content.actions.JumpingSumoAnimationAction;
import org.catrobat.catroid.content.actions.JumpingSumoJumpHighAction;
import org.catrobat.catroid.content.actions.JumpingSumoJumpLongAction;
import org.catrobat.catroid.content.actions.JumpingSumoMoveBackwardAction;
import org.catrobat.catroid.content.actions.JumpingSumoMoveForwardAction;
import org.catrobat.catroid.content.actions.JumpingSumoNoSoundAction;
import org.catrobat.catroid.content.actions.JumpingSumoRotateLeftAction;
import org.catrobat.catroid.content.actions.JumpingSumoRotateRightAction;
import org.catrobat.catroid.content.actions.JumpingSumoSoundAction;
import org.catrobat.catroid.content.actions.JumpingSumoTakingPictureAction;
import org.catrobat.catroid.content.actions.JumpingSumoTurnAction;
import org.catrobat.catroid.content.actions.LegoEv3MotorMoveAction;
import org.catrobat.catroid.content.actions.LegoEv3MotorStopAction;
import org.catrobat.catroid.content.actions.LegoEv3MotorTurnAngleAction;
import org.catrobat.catroid.content.actions.LegoEv3PlayToneAction;
import org.catrobat.catroid.content.actions.LegoEv3SetLedAction;
import org.catrobat.catroid.content.actions.LegoNxtMotorMoveAction;
import org.catrobat.catroid.content.actions.LegoNxtMotorStopAction;
import org.catrobat.catroid.content.actions.LegoNxtMotorTurnAngleAction;
import org.catrobat.catroid.content.actions.LegoNxtPlayToneAction;
import org.catrobat.catroid.content.actions.MoveNStepsAction;
import org.catrobat.catroid.content.actions.NextLookAction;
import org.catrobat.catroid.content.actions.PenDownAction;
import org.catrobat.catroid.content.actions.PenUpAction;
import org.catrobat.catroid.content.actions.PhiroMotorMoveBackwardAction;
import org.catrobat.catroid.content.actions.PhiroMotorMoveForwardAction;
import org.catrobat.catroid.content.actions.PhiroMotorStopAction;
import org.catrobat.catroid.content.actions.PhiroPlayToneAction;
import org.catrobat.catroid.content.actions.PhiroRGBLightAction;
import org.catrobat.catroid.content.actions.PlaySoundAction;
import org.catrobat.catroid.content.actions.PointInDirectionAction;
import org.catrobat.catroid.content.actions.PointToAction;
import org.catrobat.catroid.content.actions.PreviousLookAction;
import org.catrobat.catroid.content.actions.RaspiPwmAction;
import org.catrobat.catroid.content.actions.RaspiSendDigitalValueAction;
import org.catrobat.catroid.content.actions.ReadVariableFromDeviceAction;
import org.catrobat.catroid.content.actions.RepeatAction;
import org.catrobat.catroid.content.actions.RepeatUntilAction;
import org.catrobat.catroid.content.actions.ReplaceItemInUserListAction;
import org.catrobat.catroid.content.actions.SceneStartAction;
import org.catrobat.catroid.content.actions.SceneTransitionAction;
import org.catrobat.catroid.content.actions.ScriptSequenceAction;
import org.catrobat.catroid.content.actions.SetBrightnessAction;
import org.catrobat.catroid.content.actions.SetColorAction;
import org.catrobat.catroid.content.actions.SetLookAction;
import org.catrobat.catroid.content.actions.SetLookByIndexAction;
import org.catrobat.catroid.content.actions.SetNfcTagAction;
import org.catrobat.catroid.content.actions.SetPenColorAction;
import org.catrobat.catroid.content.actions.SetPenSizeAction;
import org.catrobat.catroid.content.actions.SetRotationStyleAction;
import org.catrobat.catroid.content.actions.SetSizeToAction;
import org.catrobat.catroid.content.actions.SetTextAction;
import org.catrobat.catroid.content.actions.SetTransparencyAction;
import org.catrobat.catroid.content.actions.SetVariableAction;
import org.catrobat.catroid.content.actions.SetVisibleAction;
import org.catrobat.catroid.content.actions.SetVolumeToAction;
import org.catrobat.catroid.content.actions.SetXAction;
import org.catrobat.catroid.content.actions.SetYAction;
import org.catrobat.catroid.content.actions.ShowTextAction;
import org.catrobat.catroid.content.actions.ShowTextColorSizeAlignmentAction;
import org.catrobat.catroid.content.actions.SpeakAction;
import org.catrobat.catroid.content.actions.StampAction;
import org.catrobat.catroid.content.actions.StitchAction;
import org.catrobat.catroid.content.actions.StopAllScriptsAction;
import org.catrobat.catroid.content.actions.StopAllSoundsAction;
import org.catrobat.catroid.content.actions.StopOtherScriptsAction;
import org.catrobat.catroid.content.actions.StopThisScriptAction;
import org.catrobat.catroid.content.actions.ThinkSayBubbleAction;
import org.catrobat.catroid.content.actions.TurnLeftAction;
import org.catrobat.catroid.content.actions.TurnRightAction;
import org.catrobat.catroid.content.actions.VibrateAction;
import org.catrobat.catroid.content.actions.WaitAction;
import org.catrobat.catroid.content.actions.WaitForBubbleBrickAction;
import org.catrobat.catroid.content.actions.WaitTillIdleAction;
import org.catrobat.catroid.content.actions.WaitUntilAction;
import org.catrobat.catroid.content.actions.WebRequestAction;
import org.catrobat.catroid.content.actions.WriteVariableOnDeviceAction;
import org.catrobat.catroid.content.actions.conditional.GlideToAction;
import org.catrobat.catroid.content.actions.conditional.IfOnEdgeBounceAction;
import org.catrobat.catroid.content.bricks.AddItemToUserListBrick;
import org.catrobat.catroid.content.bricks.ArduinoSendDigitalValueBrick;
import org.catrobat.catroid.content.bricks.ArduinoSendPWMValueBrick;
import org.catrobat.catroid.content.bricks.AskBrick;
import org.catrobat.catroid.content.bricks.AskSpeechBrick;
import org.catrobat.catroid.content.bricks.AssertEqualsBrick;
import org.catrobat.catroid.content.bricks.Brick;
import org.catrobat.catroid.content.bricks.BroadcastBrick;
import org.catrobat.catroid.content.bricks.BroadcastWaitBrick;
import org.catrobat.catroid.content.bricks.CameraBrick;
import org.catrobat.catroid.content.bricks.ChangeBrightnessByNBrick;
import org.catrobat.catroid.content.bricks.ChangeColorByNBrick;
import org.catrobat.catroid.content.bricks.ChangeSizeByNBrick;
import org.catrobat.catroid.content.bricks.ChangeTransparencyByNBrick;
import org.catrobat.catroid.content.bricks.ChangeVariableBrick;
import org.catrobat.catroid.content.bricks.ChangeVolumeByNBrick;
import org.catrobat.catroid.content.bricks.ChangeXByNBrick;
import org.catrobat.catroid.content.bricks.ChangeYByNBrick;
import org.catrobat.catroid.content.bricks.ChooseCameraBrick;
import org.catrobat.catroid.content.bricks.ClearBackgroundBrick;
import org.catrobat.catroid.content.bricks.ClearGraphicEffectBrick;
import org.catrobat.catroid.content.bricks.CloneBrick;
import org.catrobat.catroid.content.bricks.ComeToFrontBrick;
import org.catrobat.catroid.content.bricks.DeleteItemOfUserListBrick;
import org.catrobat.catroid.content.bricks.DeleteThisCloneBrick;
import org.catrobat.catroid.content.bricks.DroneEmergencyBrick;
import org.catrobat.catroid.content.bricks.DroneFlipBrick;
import org.catrobat.catroid.content.bricks.DroneMoveBackwardBrick;
import org.catrobat.catroid.content.bricks.DroneMoveDownBrick;
import org.catrobat.catroid.content.bricks.DroneMoveForwardBrick;
import org.catrobat.catroid.content.bricks.DroneMoveLeftBrick;
import org.catrobat.catroid.content.bricks.DroneMoveRightBrick;
import org.catrobat.catroid.content.bricks.DroneMoveUpBrick;
import org.catrobat.catroid.content.bricks.DronePlayLedAnimationBrick;
import org.catrobat.catroid.content.bricks.DroneSwitchCameraBrick;
import org.catrobat.catroid.content.bricks.DroneTakeOffLandBrick;
import org.catrobat.catroid.content.bricks.DroneTurnLeftBrick;
import org.catrobat.catroid.content.bricks.DroneTurnRightBrick;
import org.catrobat.catroid.content.bricks.FlashBrick;
import org.catrobat.catroid.content.bricks.ForeverBrick;
import org.catrobat.catroid.content.bricks.GlideToBrick;
import org.catrobat.catroid.content.bricks.GoNStepsBackBrick;
import org.catrobat.catroid.content.bricks.GoToBrick;
import org.catrobat.catroid.content.bricks.HideBrick;
import org.catrobat.catroid.content.bricks.HideTextBrick;
import org.catrobat.catroid.content.bricks.IfOnEdgeBounceBrick;
import org.catrobat.catroid.content.bricks.InsertItemIntoUserListBrick;
import org.catrobat.catroid.content.bricks.JumpingSumoAnimationsBrick;
import org.catrobat.catroid.content.bricks.JumpingSumoJumpHighBrick;
import org.catrobat.catroid.content.bricks.JumpingSumoJumpLongBrick;
import org.catrobat.catroid.content.bricks.JumpingSumoMoveBackwardBrick;
import org.catrobat.catroid.content.bricks.JumpingSumoMoveForwardBrick;
import org.catrobat.catroid.content.bricks.JumpingSumoNoSoundBrick;
import org.catrobat.catroid.content.bricks.JumpingSumoRotateLeftBrick;
import org.catrobat.catroid.content.bricks.JumpingSumoRotateRightBrick;
import org.catrobat.catroid.content.bricks.JumpingSumoSoundBrick;
import org.catrobat.catroid.content.bricks.JumpingSumoTakingPictureBrick;
import org.catrobat.catroid.content.bricks.JumpingSumoTurnBrick;
import org.catrobat.catroid.content.bricks.LegoEv3MotorMoveBrick;
import org.catrobat.catroid.content.bricks.LegoEv3MotorStopBrick;
import org.catrobat.catroid.content.bricks.LegoEv3MotorTurnAngleBrick;
import org.catrobat.catroid.content.bricks.LegoEv3PlayToneBrick;
import org.catrobat.catroid.content.bricks.LegoEv3SetLedBrick;
import org.catrobat.catroid.content.bricks.LegoNxtMotorMoveBrick;
import org.catrobat.catroid.content.bricks.LegoNxtMotorStopBrick;
import org.catrobat.catroid.content.bricks.LegoNxtMotorTurnAngleBrick;
import org.catrobat.catroid.content.bricks.LegoNxtPlayToneBrick;
import org.catrobat.catroid.content.bricks.MoveNStepsBrick;
import org.catrobat.catroid.content.bricks.NextLookBrick;
import org.catrobat.catroid.content.bricks.PenDownBrick;
import org.catrobat.catroid.content.bricks.PenUpBrick;
import org.catrobat.catroid.content.bricks.PhiroMotorMoveBackwardBrick;
import org.catrobat.catroid.content.bricks.PhiroMotorMoveForwardBrick;
import org.catrobat.catroid.content.bricks.PhiroMotorStopBrick;
import org.catrobat.catroid.content.bricks.PhiroPlayToneBrick;
import org.catrobat.catroid.content.bricks.PhiroRGBLightBrick;
import org.catrobat.catroid.content.bricks.PlaceAtBrick;
import org.catrobat.catroid.content.bricks.PlaySoundAndWaitBrick;
import org.catrobat.catroid.content.bricks.PlaySoundBrick;
import org.catrobat.catroid.content.bricks.PointInDirectionBrick;
import org.catrobat.catroid.content.bricks.PointToBrick;
import org.catrobat.catroid.content.bricks.PreviousLookBrick;
import org.catrobat.catroid.content.bricks.RaspiPwmBrick;
import org.catrobat.catroid.content.bricks.RaspiSendDigitalValueBrick;
import org.catrobat.catroid.content.bricks.ReadVariableFromDeviceBrick;
import org.catrobat.catroid.content.bricks.RepeatBrick;
import org.catrobat.catroid.content.bricks.RepeatUntilBrick;
import org.catrobat.catroid.content.bricks.ReplaceItemInUserListBrick;
import org.catrobat.catroid.content.bricks.SayBubbleBrick;
import org.catrobat.catroid.content.bricks.SayForBubbleBrick;
import org.catrobat.catroid.content.bricks.SceneStartBrick;
import org.catrobat.catroid.content.bricks.SceneTransitionBrick;
import org.catrobat.catroid.content.bricks.SetBrightnessBrick;
import org.catrobat.catroid.content.bricks.SetColorBrick;
import org.catrobat.catroid.content.bricks.SetLookBrick;
import org.catrobat.catroid.content.bricks.SetLookByIndexBrick;
import org.catrobat.catroid.content.bricks.SetNfcTagBrick;
import org.catrobat.catroid.content.bricks.SetPenColorBrick;
import org.catrobat.catroid.content.bricks.SetPenSizeBrick;
import org.catrobat.catroid.content.bricks.SetRotationStyleBrick;
import org.catrobat.catroid.content.bricks.SetSizeToBrick;
import org.catrobat.catroid.content.bricks.SetTextBrick;
import org.catrobat.catroid.content.bricks.SetTransparencyBrick;
import org.catrobat.catroid.content.bricks.SetVariableBrick;
import org.catrobat.catroid.content.bricks.SetVolumeToBrick;
import org.catrobat.catroid.content.bricks.SetXBrick;
import org.catrobat.catroid.content.bricks.SetYBrick;
import org.catrobat.catroid.content.bricks.ShowBrick;
import org.catrobat.catroid.content.bricks.ShowTextBrick;
import org.catrobat.catroid.content.bricks.ShowTextColorSizeAlignmentBrick;
import org.catrobat.catroid.content.bricks.SpeakBrick;
import org.catrobat.catroid.content.bricks.StampBrick;
import org.catrobat.catroid.content.bricks.StitchBrick;
import org.catrobat.catroid.content.bricks.StopAllSoundsBrick;
import org.catrobat.catroid.content.bricks.StopScriptBrick;
import org.catrobat.catroid.content.bricks.ThinkBubbleBrick;
import org.catrobat.catroid.content.bricks.ThinkForBubbleBrick;
import org.catrobat.catroid.content.bricks.TurnLeftBrick;
import org.catrobat.catroid.content.bricks.TurnRightBrick;
import org.catrobat.catroid.content.bricks.VibrationBrick;
import org.catrobat.catroid.content.bricks.WaitBrick;
import org.catrobat.catroid.content.bricks.WaitTillIdleBrick;
import org.catrobat.catroid.content.bricks.WaitUntilBrick;
import org.catrobat.catroid.content.bricks.WebRequestBrick;
import org.catrobat.catroid.content.bricks.WhenBackgroundChangesBrick;
import org.catrobat.catroid.content.bricks.WriteVariableOnDeviceBrick;
import org.catrobat.catroid.formulaeditor.UserVariable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertNotSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(Parameterized.class)
public class BrickActionMappingTest {

	@Parameterized.Parameters(name = "{0}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{"AddItemToUserListBrick", new AddItemToUserListBrick(), AddItemToUserListAction.class},
				{"ArduinoSendDigitalValueBrick", new ArduinoSendDigitalValueBrick(), ArduinoSendDigitalValueAction.class},
				{"ArduinoSendPWMValueBrick", new ArduinoSendPWMValueBrick(), ArduinoSendPWMValueAction.class},
				{"AskBrick", new AskBrick(), AskAction.class},
				{"AskSpeechBrick", new AskSpeechBrick(), AskSpeechAction.class},
				{"AssertEqualsBrick", new AssertEqualsBrick(), AssertEqualsAction.class},
				{"BroadcastBrick", new BroadcastBrick("message"), EventAction.class},
				{"BroadcastWaitBrick", new BroadcastWaitBrick("message"), EventAction.class},
				{"CameraBrick", new CameraBrick(), CameraBrickAction.class},
				{"ChangeBrightnessByNBrick", new ChangeBrightnessByNBrick(), ChangeBrightnessByNAction.class},
				{"ChangeColorByNBrick", new ChangeColorByNBrick(), ChangeColorByNAction.class},
				{"ChangeSizeByNBrick", new ChangeSizeByNBrick(), ChangeSizeByNAction.class},
				{"ChangeTransparencyByNBrick", new ChangeTransparencyByNBrick(), ChangeTransparencyByNAction.class},
				{"ChangeVariableBrick", new ChangeVariableBrick(), ChangeVariableAction.class},
				{"ChangeVolumeByNBrick", new ChangeVolumeByNBrick(), ChangeVolumeByNAction.class},
				{"ChangeXByNBrick", new ChangeXByNBrick(), ChangeXByNAction.class},
				{"ChangeYByNBrick", new ChangeYByNBrick(), ChangeYByNAction.class},
				{"ChooseCameraBrick", new ChooseCameraBrick(), ChooseCameraAction.class},
				{"ClearBackgroundBrick", new ClearBackgroundBrick(), ClearBackgroundAction.class},
				{"ClearGraphicEffectBrick", new ClearGraphicEffectBrick(), ClearGraphicEffectAction.class},
				{"CloneBrick", new CloneBrick(), CloneAction.class},
				{"ComeToFrontBrick", new ComeToFrontBrick(), ComeToFrontAction.class},
				{"DeleteItemOfUserListBrick", new DeleteItemOfUserListBrick(), DeleteItemOfUserListAction.class},
				{"DeleteThisCloneBrick", new DeleteThisCloneBrick(), DeleteThisCloneAction.class},
				{"DroneEmergencyBrick", new DroneEmergencyBrick(), DroneEmergencyAction.class},
				{"DroneFlipBrick", new DroneFlipBrick(), DroneFlipAction.class},
				{"DroneMoveBackwardBrick", new DroneMoveBackwardBrick(), DroneMoveBackwardAction.class},
				{"DroneMoveDownBrick", new DroneMoveDownBrick(), DroneMoveDownAction.class},
				{"DroneMoveForwardBrick", new DroneMoveForwardBrick(), DroneMoveForwardAction.class},
				{"DroneMoveLeftBrick", new DroneMoveLeftBrick(), DroneMoveLeftAction.class},
				{"DroneMoveRightBrick", new DroneMoveRightBrick(), DroneMoveRightAction.class},
				{"DroneMoveUpBrick", new DroneMoveUpBrick(), DroneMoveUpAction.class},
				{"DronePlayLedAnimationBrick", new DronePlayLedAnimationBrick(), DronePlayLedAnimationAction.class},
				{"DroneSwitchCameraBrick", new DroneSwitchCameraBrick(), DroneSwitchCameraAction.class},
				{"DroneTakeOffLandBrick", new DroneTakeOffLandBrick(), DroneTakeoffAndLandAction.class},
				{"DroneTurnLeftBrick", new DroneTurnLeftBrick(), DroneTurnLeftAction.class},
				{"DroneTurnRightBrick", new DroneTurnRightBrick(), DroneTurnRightAction.class},
				{"FlashBrick", new FlashBrick(), FlashAction.class},
				{"ForeverBrick", new ForeverBrick(), RepeatAction.class},
				{"GlideToBrick", new GlideToBrick(), GlideToAction.class},
				{"GoNStepsBackBrick", new GoNStepsBackBrick(), GoNStepsBackAction.class},
				{"GoToBrick Touch", new GoToBrick(BrickValues.GO_TO_TOUCH_POSITION), GoToTouchPositionAction.class},
				{"GoToBrick Random", new GoToBrick(BrickValues.GO_TO_RANDOM_POSITION), GoToRandomPositionAction.class},
				{"GoToBrick OtherSprite", new GoToBrick(BrickValues.GO_TO_OTHER_SPRITE_POSITION), GoToOtherSpritePositionAction.class},
				{"HideBrick", new HideBrick(), SetVisibleAction.class},
				{"HideTextBrick", new HideTextBrick(), HideTextAction.class},
				{"IfOnEdgeBounceBrick", new IfOnEdgeBounceBrick(), IfOnEdgeBounceAction.class},
				{"InsertItemIntoUserListBrick", new InsertItemIntoUserListBrick(), InsertItemIntoUserListAction.class},
				{"JumpingSumoAnimationsBrick", new JumpingSumoAnimationsBrick(), JumpingSumoAnimationAction.class},
				{"JumpingSumoJumpHighBrick", new JumpingSumoJumpHighBrick(), JumpingSumoJumpHighAction.class},
				{"JumpingSumoJumpLongBrick", new JumpingSumoJumpLongBrick(), JumpingSumoJumpLongAction.class},
				{"JumpingSumoMoveBackwardBrick", new JumpingSumoMoveBackwardBrick(), JumpingSumoMoveBackwardAction.class},
				{"JumpingSumoMoveForwardBrick", new JumpingSumoMoveForwardBrick(), JumpingSumoMoveForwardAction.class},
				{"JumpingSumoNoSoundBrick", new JumpingSumoNoSoundBrick(), JumpingSumoNoSoundAction.class},
				{"JumpingSumoRotateLeftBrick", new JumpingSumoRotateLeftBrick(), JumpingSumoRotateLeftAction.class},
				{"JumpingSumoRotateRightBrick", new JumpingSumoRotateRightBrick(), JumpingSumoRotateRightAction.class},
				{"JumpingSumoSoundBrick", new JumpingSumoSoundBrick(), JumpingSumoSoundAction.class},
				{"JumpingSumoTakingPictureBrick", new JumpingSumoTakingPictureBrick(), JumpingSumoTakingPictureAction.class},
				{"JumpingSumoTurnBrick", new JumpingSumoTurnBrick(), JumpingSumoTurnAction.class},
				{"LegoEv3MotorMoveBrick", new LegoEv3MotorMoveBrick(), LegoEv3MotorMoveAction.class},
				{"LegoEv3MotorStopBrick", new LegoEv3MotorStopBrick(), LegoEv3MotorStopAction.class},
				{"LegoEv3MotorTurnAngleBrick", new LegoEv3MotorTurnAngleBrick(), LegoEv3MotorTurnAngleAction.class},
				{"LegoEv3PlayToneBrick", new LegoEv3PlayToneBrick(), LegoEv3PlayToneAction.class},
				{"LegoEv3SetLedBrick", new LegoEv3SetLedBrick(), LegoEv3SetLedAction.class},
				{"LegoNxtMotorMoveBrick", new LegoNxtMotorMoveBrick(), LegoNxtMotorMoveAction.class},
				{"LegoNxtMotorStopBrick", new LegoNxtMotorStopBrick(), LegoNxtMotorStopAction.class},
				{"LegoNxtMotorTurnAngleBrick", new LegoNxtMotorTurnAngleBrick(), LegoNxtMotorTurnAngleAction.class},
				{"LegoNxtPlayToneBrick", new LegoNxtPlayToneBrick(), LegoNxtPlayToneAction.class},
				{"MoveNStepsBrick", new MoveNStepsBrick(), MoveNStepsAction.class},
				{"NextLookBrick", new NextLookBrick(), NextLookAction.class},
				{"PenDownBrick", new PenDownBrick(), PenDownAction.class},
				{"PenUpBrick", new PenUpBrick(), PenUpAction.class},
				{"PhiroMotorMoveBackwardBrick", new PhiroMotorMoveBackwardBrick(), PhiroMotorMoveBackwardAction.class},
				{"PhiroMotorMoveForwardBrick", new PhiroMotorMoveForwardBrick(), PhiroMotorMoveForwardAction.class},
				{"PhiroMotorStopBrick", new PhiroMotorStopBrick(), PhiroMotorStopAction.class},
				{"PhiroPlayToneBrick", new PhiroPlayToneBrick(), PhiroPlayToneAction.class},
				{"PhiroRGBLightBrick", new PhiroRGBLightBrick(), PhiroRGBLightAction.class},
				{"PlaceAtBrick", new PlaceAtBrick(), GlideToAction.class},
				{"PlaySoundAndWaitBrick Play", new PlaySoundAndWaitBrick(), PlaySoundAction.class},
				{"PlaySoundAndWaitBrick Wait", new PlaySoundAndWaitBrick(), WaitAction.class},
				{"PlaySoundBrick", new PlaySoundBrick(), PlaySoundAction.class},
				{"PointInDirectionBrick", new PointInDirectionBrick(), PointInDirectionAction.class},
				{"PointToBrick", new PointToBrick(), PointToAction.class},
				{"PreviousLookBrick", new PreviousLookBrick(), PreviousLookAction.class},
				{"RaspiPwmBrick", new RaspiPwmBrick(), RaspiPwmAction.class},
				{"RaspiSendDigitalValueBrick", new RaspiSendDigitalValueBrick(), RaspiSendDigitalValueAction.class},
				{"ReadVariableFromDeviceBrick", new ReadVariableFromDeviceBrick(new UserVariable("variable")), ReadVariableFromDeviceAction.class},
				{"RepeatBrick", new RepeatBrick(), RepeatAction.class},
				{"RepeatUntilBrick", new RepeatUntilBrick(), RepeatUntilAction.class},
				{"ReplaceItemInUserListBrick", new ReplaceItemInUserListBrick(), ReplaceItemInUserListAction.class},
				{"SayBubbleBrick", new SayBubbleBrick(), ThinkSayBubbleAction.class},
				{"SayForBubbleBrick", new SayForBubbleBrick(), ThinkSayBubbleAction.class},
				{"SayForBubbleBrick Say", new SayForBubbleBrick(), ThinkSayBubbleAction.class},
				{"SayForBubbleBrick Wait", new SayForBubbleBrick(), WaitForBubbleBrickAction.class},
				{"SceneStartBrick", new SceneStartBrick("scene"), SceneStartAction.class},
				{"SceneTransitionBrick", new SceneTransitionBrick("scene"), SceneTransitionAction.class},
//				{"SetBackgroundAndWaitBrick", new SetBackgroundAndWaitBrick(), SetBackgroundLookAction.class},
//				{"SetBackgroundBrick", new SetBackgroundBrick(), SetBackgroundLookAction.class},
//				{"SetBackgroundByIndexAndWaitBrick", new SetBackgroundByIndexAndWaitBrick(), SetBackgroundLookAction.class},
//				{"SetBackgroundByIndexBrick", new SetBackgroundByIndexBrick(), SetBackgroundLookAction.class},
				{"SetBrightnessBrick", new SetBrightnessBrick(), SetBrightnessAction.class},
				{"SetColorBrick", new SetColorBrick(), SetColorAction.class},
				{"SetLookBrick", new SetLookBrick(), SetLookAction.class},
				{"SetLookByIndexBrick", new SetLookByIndexBrick(), SetLookByIndexAction.class},
				{"SetNfcTagBrick", new SetNfcTagBrick(), SetNfcTagAction.class},
				{"SetPenColorBrick", new SetPenColorBrick(), SetPenColorAction.class},
				{"SetPenSizeBrick", new SetPenSizeBrick(), SetPenSizeAction.class},
				{"SetRotationStyleBrick", new SetRotationStyleBrick(), SetRotationStyleAction.class},
				{"SetSizeToBrick", new SetSizeToBrick(), SetSizeToAction.class},
				{"SetTextBrick", new SetTextBrick(), SetTextAction.class},
				{"SetTransparencyBrick", new SetTransparencyBrick(), SetTransparencyAction.class},
				{"SetVariableBrick", new SetVariableBrick(), SetVariableAction.class},
				{"SetVolumeToBrick", new SetVolumeToBrick(), SetVolumeToAction.class},
				{"SetXBrick", new SetXBrick(), SetXAction.class},
				{"SetYBrick", new SetYBrick(), SetYAction.class},
				{"ShowBrick", new ShowBrick(), SetVisibleAction.class},
				{"ShowTextBrick", new ShowTextBrick(), ShowTextAction.class},
				{"ShowTextColorSizeAlignmentBrick", new ShowTextColorSizeAlignmentBrick(), ShowTextColorSizeAlignmentAction.class},
//				{"SpeakAndWaitBrick", new SpeakAndWaitBrick(), SpeakAction.class},
				{"SpeakBrick", new SpeakBrick(), SpeakAction.class},
				{"StampBrick", new StampBrick(), StampAction.class},
				{"StitchBrick", new StitchBrick(), StitchAction.class},
				{"StopAllSoundsBrick", new StopAllSoundsBrick(), StopAllSoundsAction.class},
				{"StopScriptBrick AllScripts", new StopScriptBrick(BrickValues.STOP_ALL_SCRIPTS), StopAllScriptsAction.class},
				{"StopScriptBrick OtherScript", new StopScriptBrick(BrickValues.STOP_OTHER_SCRIPTS), StopOtherScriptsAction.class},
				{"StopScriptBrick ThisScript", new StopScriptBrick(BrickValues.STOP_THIS_SCRIPT), StopThisScriptAction.class},
				{"ThinkBubbleBrick", new ThinkBubbleBrick(), ThinkSayBubbleAction.class},
				{"ThinkForBubbleBrick", new ThinkForBubbleBrick(), ThinkSayBubbleAction.class},
				{"ThinkForBubbleBrick Wait", new ThinkForBubbleBrick(), WaitForBubbleBrickAction.class},
				{"TurnLeftBrick", new TurnLeftBrick(), TurnLeftAction.class},
				{"TurnRightBrick", new TurnRightBrick(), TurnRightAction.class},
				{"VibrationBrick", new VibrationBrick(), VibrateAction.class},
				{"WaitBrick", new WaitBrick(), WaitAction.class},
				{"WaitTillIdleBrick", new WaitTillIdleBrick(), WaitTillIdleAction.class},
				{"WaitUntilBrick", new WaitUntilBrick(), WaitUntilAction.class},
				{"WebRequestBrick", new WebRequestBrick(), WebRequestAction.class},
				{"WhenBackgroundChangesBrick", new WhenBackgroundChangesBrick(), SetLookAction.class},
				{"WriteVariableOnDeviceBrick", new WriteVariableOnDeviceBrick(new UserVariable("variable")), WriteVariableOnDeviceAction.class},
		});
	}

	@Parameterized.Parameter
	public String name;

	@Parameterized.Parameter(1)
	public Brick brick;

	@Parameterized.Parameter(2)
	public Class<Action> actionClazz;

	@Before
	public void setUp() {
		ProjectManager.getInstance().setCurrentProject(mock(Project.class));
	}

	@Test
	public void testBrickActionMapping() {
		Sprite sprite = new Sprite();
		ScriptSequenceAction sequenceAction = mock(ScriptSequenceAction.class);
		brick.addActionToSequence(sprite, sequenceAction);
		verify(sequenceAction, times(1)).addAction(any(actionClazz));
	}

	@Test
	public void testClone() throws CloneNotSupportedException {
		Brick clone = brick.clone();
		assertNotSame(brick, clone);
	}
}
