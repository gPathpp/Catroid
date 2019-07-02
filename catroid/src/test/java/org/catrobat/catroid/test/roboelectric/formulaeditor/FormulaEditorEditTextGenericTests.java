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

package org.catrobat.catroid.test.roboelectric.formulaeditor;

import android.support.v4.app.Fragment;
import android.support.v4.app.SupportActivity;

import org.catrobat.catroid.ProjectManager;
import org.catrobat.catroid.R;
import org.catrobat.catroid.content.Project;
import org.catrobat.catroid.content.Script;
import org.catrobat.catroid.content.Sprite;
import org.catrobat.catroid.content.StartScript;
import org.catrobat.catroid.content.bricks.Brick;
import org.catrobat.catroid.content.bricks.ChangeSizeByNBrick;
import org.catrobat.catroid.formulaeditor.Formula;
import org.catrobat.catroid.ui.SpriteActivity;
import org.catrobat.catroid.ui.fragment.FormulaEditorFragment;
import org.catrobat.catroid.ui.recyclerview.fragment.ScriptFragment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.ParameterizedRobolectricTestRunner;
import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.android.controller.FragmentController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentController;
import org.robolectric.util.FragmentTestUtil;
import org.robolectric.*;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(ParameterizedRobolectricTestRunner.class)
public class FormulaEditorEditTextGenericTests {

	@ParameterizedRobolectricTestRunner.Parameters(name = "{2}" + "-Test")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{R.id.formula_editor_keyboard_0, "0", "button_0"},
				{R.id.formula_editor_keyboard_1, "1", "button_1"},
				{R.id.formula_editor_keyboard_2, "2", "button_2"},
				{R.id.formula_editor_keyboard_3, "3", "button_3"},
				{R.id.formula_editor_keyboard_4, "4", "button_4"},
				{R.id.formula_editor_keyboard_5, "5", "button_5"},
				{R.id.formula_editor_keyboard_6, "6", "button_6"},
				{R.id.formula_editor_keyboard_7, "7", "button_7"},
				{R.id.formula_editor_keyboard_8, "8", "button_8"},
				{R.id.formula_editor_keyboard_9, "9", "button_9"},
//				{R.id.formula_editor_keyboard_decimal_mark,
//						"0" + RuntimeEnvironment.application.getString(R.string.formula_editor_decimal_mark), "button_decimal_mark"},
//				{R.id.formula_editor_keyboard_plus,	RuntimeEnvironment.application.getString(R.string.formula_editor_operator_plus), "button_plus"},
				{R.id.formula_editor_keyboard_minus, "-", "button_minus"},
				{R.id.formula_editor_keyboard_mult, "*", "button_mult"}
//				{R.id.formula_editor_keyboard_divide,
//						RuntimeEnvironment.application.getString(R.string.formula_editor_operator_divide), "button_divide"},
//				{R.id.formula_editor_keyboard_bracket_open,
//						RuntimeEnvironment.application.getString(R.string.formula_editor_bracket_open), "button_bracket_open"},
//				{R.id.formula_editor_keyboard_bracket_close,
//						RuntimeEnvironment.application.getString(R.string.formula_editor_bracket_close), "button_bracket_close"}
		});
	}

	private int formulaEditorKeyboardButton;

	private String shouldBe;

	private String testName;

	public FormulaEditorEditTextGenericTests(int formulaEditorKeyboardButton, String shouldBe, String testName) {
		this.formulaEditorKeyboardButton = formulaEditorKeyboardButton;
		this.shouldBe = shouldBe;
		this.testName = testName;
	}

	private SpriteActivity activity;
	private Brick brick;

	@Before
	public void setUp() throws Exception {
		FormulaEditorFragment fragment = new FormulaEditorFragment();
		ActivityController<SpriteActivity> activityController = Robolectric.buildActivity( SpriteActivity.class );
		activity = activityController.get();
		Shadows.shadowOf(activity);
		activity.getSupportFragmentManager()
		FragmentController<FormulaEditorFragment> tFragmentController = Robolectric.buildFragment();
		Support
		Script script = createProjectAndGetStartScript("project");
		Brick brick = new ChangeSizeByNBrick(new Formula(10));
		script.addBrick(brick);

		activity = activityController.create().start().resume().get();
		assertTrue(brick.getView(activity).findViewById(R.id.brick_change_size_by_edit_text).performClick());
		Fragment fragment1 = new ScriptFragment();
		FragmentTestUtil.start;
//		FragmentActivity fragmentActivity = activityController.create().start().resume().get();
//		FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
//		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//		fragmentTransaction.add( fragment, null );
//		fragmentTransaction.commit();
	}

	@Test
	public void testCustomKeys() {
	///	activity.findViewById(formulaEditorKeyboardButton).performClick();
//		onView(formulaEditorKeyboardButton)
//				.perform(click());
//		onFormulaEditor().checkShows(shouldBe + " ");
//
		//activity.findViewById(R.id.brick_change_size_by_edit_text).performClick();
//		Assert.assertNotNull(shouldBe);
//		Assert.assertNotNull(formulaEditorKeyboardButton);
//		Assert.assertNotNull(testName);
	}

	public Script createProjectAndGetStartScript(String projectName) {
		Project project = new Project(activity.getBaseContext(), projectName);
		Sprite sprite = new Sprite("testSprite");
		Script script = new StartScript();

		sprite.addScript(script);
		project.getDefaultScene().addSprite(sprite);
		ProjectManager.getInstance().setCurrentProject(project);
		ProjectManager.getInstance().setCurrentSprite(sprite);
		ProjectManager.getInstance().setCurrentlyEditedScene(project.getDefaultScene());
		return script;
	}
}
