/**
 * OpenERP, Open Source Management Solution
 * Copyright (C) 2012-today OpenERP SA (<http://www.openerp.com>)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 */
package com.openerp.util.drawer;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.openerp.config.ModulesConfig;
import com.openerp.support.Module;
import com.openerp.support.fragment.FragmentHelper;

public class DrawerHelper {
	public static List<DrawerItem> drawerItems(Context context) {
		List<DrawerItem> items = new ArrayList<DrawerItem>();
		for (Module module : new ModulesConfig().modules()) {
			FragmentHelper model = (FragmentHelper) module.getModuleInstance();
			List<DrawerItem> drawerItems = model.drawerMenus(context);
			if (drawerItems != null)
				items.addAll(drawerItems);
		}
		return items;
	}
}
