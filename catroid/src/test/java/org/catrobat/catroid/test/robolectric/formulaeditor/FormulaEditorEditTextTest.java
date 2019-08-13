/*
 * Catroid: An on-device visual programming system for Android devices
 * Copyright (C) 2010-2019 The Catrobat Team
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

package org.catrobat.catroid.test.robolectric.formulaeditor;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import org.catrobat.catroid.ProjectManager;
import org.catrobat.catroid.R;
import org.catrobat.catroid.content.Project;
import org.catrobat.catroid.content.Script;
import org.catrobat.catroid.content.Sprite;
import org.catrobat.catroid.content.StartScript;
import org.catrobat.catroid.content.bricks.Brick;
import org.catrobat.catroid.content.bricks.FormulaBrick;
import org.catrobat.catroid.content.bricks.SetXBrick;
import org.catrobat.catroid.formulaeditor.FormulaEditorEditText;
import org.catrobat.catroid.ui.SpriteActivity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.util.reflector.Static;

import static org.catrobat.catroid.test.robolectric.formulaeditor.wrapper.FormulaEditorWrapper.Control.BACKSPACE;
import static org.catrobat.catroid.test.robolectric.formulaeditor.wrapper.FormulaEditorWrapper.FORMULA_EDITOR_TEXT_FIELD_ID;
import static org.catrobat.catroid.test.robolectric.formulaeditor.wrapper.FormulaEditorWrapper.onFormulaEditor;

@RunWith(RobolectricTestRunner.class)
//@Config(shadows = BuildConfig.class)
@PowerMockIgnore({ "org.mockito.*", "org.robolectric.*", "android.*" })
@PrepareForTest(Static.class)
public class FormulaEditorEditTextTest {

	private SpriteActivity activity;

	@Before
	public void setUp() throws Exception {
		ActivityController<SpriteActivity> activityController = Robolectric.buildActivity(SpriteActivity.class);
		activity = activityController.get();
		FormulaBrick brick = new SetXBrick();
		createProject(activity, brick);
		activityController.create().resume();
		View brickView = brick.getView(activity);
		TextView brickFormulaTextView = brickView.findViewById(R.id.brick_set_x_edit_text);
		brick.onClick(brickFormulaTextView);
	}

	private void createProject(Activity activity, Brick brick) {
		Project project = new Project(activity, getClass().getSimpleName());
		Sprite sprite = new Sprite("testSprite");
		Script script = new StartScript();
		script.addBrick(brick);
		sprite.addScript(script);
		project.getDefaultScene().addSprite(sprite);
		ProjectManager.getInstance().setCurrentProject(project);
		ProjectManager.getInstance().setCurrentSprite(sprite);
		ProjectManager.getInstance().setCurrentlyEditedScene(project.getDefaultScene());
	}

	@Test
	public void testDoubleTapSelection() {
		onFormulaEditor().performEnterFormula(activity, "1234");
		FormulaEditorEditText editText = activity.findViewById(FORMULA_EDITOR_TEXT_FIELD_ID);
		Shadows.shadowOf(editText.gestureDetector).getOnDoubleTapListener().onDoubleTap(null);
		onFormulaEditor().performTouchOn(activity, BACKSPACE);
		onFormulaEditor().checkShows(activity, " ");
	}

//	@Test
//	public void testLongClickDeletion() {
//		onFormulaEditor().performEnterFormula(activity, "1234");
//		activity.findViewById(BACKSPACE).performLongClick();//1, new KeyEvent(KeyEvent.ACTION_DOWN, 1));
//		onFormulaEditor().checkShows(activity," ");
//	}

//	@Test
//	public void testDiscardDialogDiscardSaveYes() {
//		onFormulaEditor().performEnterFormula(activity,"99");
//		activity.onBackPressed();
//		do
//		onView(withText(R.string.formula_editor_discard_changes_dialog_title))
//				.check(matches(isDisplayed()));
//
//		pressBack();
//
//		onFormulaEditor()
//				.performEnterFormula(".9");
//		pressBack();
//		onView(withText(R.string.formula_editor_discard_changes_dialog_title))
//				.check(matches(isDisplayed()));
//		onView(withText(yes))
//				.perform(click());
//		onToast(withText(R.string.formula_editor_changes_saved))
//				.check(matches(isDisplayed()));
//		onBrickAtPosition(1)
//				.checkShowsText("99" + decimalMark + "9 ");
//		onView(isRoot()).perform(CustomActions.wait(3000));
//	}
//
//	@Category({Cat.CatrobatLanguage.class, Level.Smoke.class})
//	@Test
//	public void testFormulaIsNotValidToast1() {
//		onFormulaEditor()
//				.performTouchOn(BACKSPACE);
//		onFormulaEditor()
//				.performTouchOn(OK);
//		onToast(withText(R.string.formula_editor_parse_fail))
//				.check(matches(isDisplayed()));
//		onView(isRoot()).perform(CustomActions.wait(3000));
//	}

//	@Test
//	public void testFormulaIsNotValidToast2() {
//		onFormulaEditor().performTouchOn(activity, BACKSPACE);
//		onFormulaEditor().performEnterFormula(activity, "1+1+");
//		activity.onBackPressed();
//		activity.
//		assertEquals(activity.getString(R.string.formula_editor_discard_changes_dialog_title),
//				activity.findViewById(R.string.formula_editor_discard_changes_dialog_title).toString());
//
//		activity.
//		onView(withText(R.string.formula_editor_discard_changes_dialog_title))
//				.check(matches(isDisplayed()));
//		onView(withText(yes))
//				.perform(click());
//		onToast(withText(R.string.formula_editor_parse_fail))
//				.check(matches(isDisplayed()));
//		onView(isRoot()).perform(CustomActions.wait(3000));
//	}

//	@Test
//	public void testFormulaIsNotValidToast3() {
//		onFormulaEditor().performTouchOn(activity, BACKSPACE);
//		onFormulaEditor().performEnterFormula(activity, "+");
//		onFormulaEditor().performTouchOn(activity, OK);
//		assertEquals(activity.getString(R.string.formula_editor_parse_fail), ShadowToast.getTextOfLatestToast());
//	}

//	@Category({Cat.CatrobatLanguage.class, Level.Smoke.class})
//	@Test
//	public void testComputeDialog() {
//		onFormulaEditor()
//				.performEnterFormula("-2");
//		onFormulaEditor()
//				.performTouchOn(COMPUTE);
//		onView(withId(R.id.formula_editor_compute_dialog_textview))
//				.check(matches(withText("-2")));
//		pressBack();
//
//		onFormulaEditor()
//				.performEnterFormula("-6.111-");
//		onFormulaEditor()
//				.performTouchOn(COMPUTE);
//		onFormulaEditor()
//				.performTouchOn(BACKSPACE);
//		onFormulaEditor()
//				.performTouchOn(COMPUTE);
//		onView(withId(R.id.formula_editor_compute_dialog_textview))
//				.check(matches(withText("-8.111")));
//	}
}
