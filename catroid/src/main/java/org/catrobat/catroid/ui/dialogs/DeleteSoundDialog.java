/*
 * Catroid: An on-device visual programming system for Android devices
 * Copyright (C) 2010-2017 The Catrobat Team
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
package org.catrobat.catroid.ui.dialogs;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import org.catrobat.catroid.ProjectManager;
import org.catrobat.catroid.R;
import org.catrobat.catroid.common.SoundInfo;
import org.catrobat.catroid.io.StorageHandler;
import org.catrobat.catroid.ui.ScriptActivity;
import org.catrobat.catroid.utils.TextSizeUtil;

import java.util.List;

public class DeleteSoundDialog extends DialogFragment {

	private static final String BUNDLE_ARGUMENTS_SELECTED_POSITION = "selected_position";
	public static final String DIALOG_FRAGMENT_TAG = "dialog_delete_sound";

	public static DeleteSoundDialog newInstance(int selectedPosition) {
		DeleteSoundDialog dialog = new DeleteSoundDialog();

		Bundle arguments = new Bundle();
		arguments.putInt(BUNDLE_ARGUMENTS_SELECTED_POSITION, selectedPosition);
		dialog.setArguments(arguments);

		return dialog;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final int selectedPosition = getArguments().getInt(BUNDLE_ARGUMENTS_SELECTED_POSITION);

		final Dialog dialog = new CustomAlertDialogBuilder(getActivity()).setTitle(R.string.delete_sound_dialog)
				.setNegativeButton(R.string.cancel, new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dismiss();
					}
				}).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						handleDeleteSound(selectedPosition);
					}
				}).create();

		dialog.setCanceledOnTouchOutside(true);

		dialog.setOnShowListener(new DialogInterface.OnShowListener() {
			@Override
			public void onShow(DialogInterface dialogInterface) {
				if (getActivity() == null) {
					Log.e(DIALOG_FRAGMENT_TAG, "onShow() Activity was null!");
					return;
				}

				TextSizeUtil.enlargeViewGroup((ViewGroup) dialog.getWindow().getDecorView().getRootView());
			}
		});

		return dialog;
	}

	private void handleDeleteSound(int position) {
		List<SoundInfo> soundInfoList = ProjectManager.getInstance().getCurrentSprite().getSoundList();
		StorageHandler.getInstance().deleteFile(soundInfoList.get(position).getAbsolutePath(), false);
		soundInfoList.remove(position);

		getActivity().sendBroadcast(new Intent(ScriptActivity.ACTION_SOUND_DELETED));
	}
}
