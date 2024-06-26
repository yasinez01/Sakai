/**********************************************************************************
 * $URL$
 * $Id$
 ***********************************************************************************
 *
 * Copyright (c) 2005, 2006, 2008 Sakai Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.opensource.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **********************************************************************************/

package org.sakaiproject.authz.api;

/**
 * <p>
 * GroupAlreadyDefinedException is thrown whenever an Authz Group is created with an id that already is defined for a group.
 * </p>
 */
public class GroupAlreadyDefinedException extends Exception
{
	private String m_id = null;

	public GroupAlreadyDefinedException(String id)
	{
		m_id = id;
	}

	public String toString()
	{
		return super.toString() + " id=" + m_id;
	}
}
