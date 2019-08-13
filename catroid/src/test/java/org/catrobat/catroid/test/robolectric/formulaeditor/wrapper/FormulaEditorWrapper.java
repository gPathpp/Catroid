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

package org.catrobat.catroid.test.robolectric.formulaeditor.wrapper;

import android.app.Activity;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.EditText;

import org.catrobat.catroid.R;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public final class FormulaEditorWrapper {

	public static final int FORMULA_EDITOR_KEYBOARD_ID = R.id.formula_editor_keyboardview;
	public static final int FORMULA_EDITOR_TEXT_FIELD_ID = R.id.formula_editor_edit_field;

	public static FormulaEditorWrapper onFormulaEditor() {
		return new FormulaEditorWrapper();
	}

	public <V extends Number> FormulaEditorWrapper performEnterNumber(V valueToBeEntered, Activity activity) {
		String value = "";

		if (valueToBeEntered instanceof Float) {
			value = String.format("%f", valueToBeEntered.floatValue());
		} else if (valueToBeEntered instanceof Double) {
			value = String.format("%f", valueToBeEntered.doubleValue());
		} else if (valueToBeEntered instanceof Integer) {
			value = String.format("%d", valueToBeEntered.intValue());
		}

		return performEnterFormula(activity, value);
	}

	public FormulaEditorWrapper performEnterFormula(Activity activity, String formulaString) {
		for (Character item : formulaString.toCharArray()) {
			if (!charToButtonMapping.keySet().contains(item)) {
				throw new IllegalArgumentException("Formula or Number contained illegal character: " + item
						+ " contained in: " + formulaString);
			}

			performTouchOn(activity, charToButtonMapping.get(item));
		}
		return new FormulaEditorWrapper();
	}


	public FormulaEditorWrapper checkShows(Activity activity, String expected) {
		EditText formulaEditField = activity.findViewById(FORMULA_EDITOR_TEXT_FIELD_ID);
		String actual = formulaEditField.getText().toString();
		assertEquals(expected, actual);
		return new FormulaEditorWrapper();
	}

	public FormulaEditorWrapper checkValue(Activity activity, String expected) {
		EditText formulaEditField = activity.findViewById(FORMULA_EDITOR_TEXT_FIELD_ID);
		String actual = formulaEditField.getText().toString().trim();
		assertEquals(expected, actual);
		return new FormulaEditorWrapper();
	}


	public void performOpenDataFragment(Activity activity) {
		activity.findViewById(Control.DATA)
				.performClick();
	}

	public void performCloseAndSave(Activity activity) {
		activity.findViewById(Control.OK)
				.performClick();
	}

	public void performTouchOn(Activity activity, int id) {
		MotionEvent touchDown = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
				MotionEvent.ACTION_DOWN, 1, 1, 0);
		activity.findViewById(id).dispatchTouchEvent(touchDown);
		MotionEvent touchUp = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
				MotionEvent.ACTION_UP, 1, 1, 0);
		activity.findViewById(id).dispatchTouchEvent(touchUp);
	}

	public void performBackspace(Activity activity) {
		activity.findViewById(Control.BACKSPACE)
				.performClick();
	}

	public void performCompute(Activity activity) {
		activity.findViewById(Control.COMPUTE)
				.performClick();
	}

	public void performUndo(Activity activity) {
		activity.findViewById(ActionMenu.UNDO)
				.performClick();
	}

	public void performRedo(Activity activity) {
		activity.findViewById(ActionMenu.REDO)
				.performClick();
	}
	public FormulaEditorWrapper performOpenCategory(Activity activity,int category) {
		activity.findViewById(category).performClick();
		return this;
	}

	private static Map<Character, Integer> charToButtonMapping;
	static {
		Map<Character, Integer> numpad = new HashMap<>();
		numpad.put('0', NumPad.NUM0);
		numpad.put('1', NumPad.NUM1);
		numpad.put('2', NumPad.NUM2);
		numpad.put('3', NumPad.NUM3);
		numpad.put('4', NumPad.NUM4);
		numpad.put('5', NumPad.NUM5);
		numpad.put('6', NumPad.NUM6);
		numpad.put('7', NumPad.NUM7);
		numpad.put('8', NumPad.NUM8);
		numpad.put('9', NumPad.NUM9);
		numpad.put('.', NumPad.COMMA);
		numpad.put(',', NumPad.COMMA);
		numpad.put('+', Math.PLUS);
		numpad.put('-', Math.MINUS);
		numpad.put('*', Math.MULT);
		numpad.put('/', Math.DIVIDE);
		numpad.put('(', Math.BRACKETOPEN);
		numpad.put(')', Math.BRACKETCLOSE);
		numpad.put('=', Math.EQUAL);

		charToButtonMapping = Collections.unmodifiableMap(numpad);
	}

	public static final class NumPad {
		public static final int NUM0 = R.id.formula_editor_keyboard_0;
		public static final int NUM1 = R.id.formula_editor_keyboard_1;
		public static final int NUM2 = R.id.formula_editor_keyboard_2;
		public static final int NUM3 = R.id.formula_editor_keyboard_3;
		public static final int NUM4 = R.id.formula_editor_keyboard_4;
		public static final int NUM5 = R.id.formula_editor_keyboard_5;
		public static final int NUM6 = R.id.formula_editor_keyboard_6;
		public static final int NUM7 = R.id.formula_editor_keyboard_7;
		public static final int NUM8 = R.id.formula_editor_keyboard_8;
		public static final int NUM9 = R.id.formula_editor_keyboard_9;
		public static final int COMMA = R.id.formula_editor_keyboard_decimal_mark;
	}

	public static final class Math {
		public static final int PLUS = R.id.formula_editor_keyboard_plus;
		public static final int MINUS = R.id.formula_editor_keyboard_minus;
		public static final int MULT = R.id.formula_editor_keyboard_mult;
		public static final int DIVIDE = R.id.formula_editor_keyboard_divide;
		public static final int EQUAL = R.id.formula_editor_keyboard_equal;
		public static final int BRACKETOPEN = R.id.formula_editor_keyboard_bracket_open;
		public static final int BRACKETCLOSE = R.id.formula_editor_keyboard_bracket_close;
	}

	public static final class Control {
		public static final int OK = R.id.formula_editor_keyboard_ok;
		public static final int COMPUTE = R.id.formula_editor_keyboard_compute;
		public static final int BACKSPACE = R.id.formula_editor_keyboard_delete;
		public static final int DATA = R.id.formula_editor_keyboard_data;
		public static final int TEXT = R.id.formula_editor_keyboard_string;
	}

	public static final class Category {
		public static final int OBJECT = R.id.formula_editor_keyboard_object;
		public static final int FUNCTIONS = R.id.formula_editor_keyboard_function;
		public static final int LOGIC = R.id.formula_editor_keyboard_logic;
		public static final int DEVICE = R.id.formula_editor_keyboard_sensors;
	}

	public static final class ActionMenu {
		public static final int UNDO = R.id.menu_undo;
		public static final int REDO = R.id.menu_redo;
	}
}
