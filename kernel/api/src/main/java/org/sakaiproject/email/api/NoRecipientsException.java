/**********************************************************************************
 * Copyright 2008 Sakai Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **********************************************************************************/
package org.sakaiproject.email.api;

public class NoRecipientsException extends Exception
{
	/**
	 * Default serial version ID.
	 */
	private static final long serialVersionUID = 1L;

	public NoRecipientsException()
	{
	}

	public NoRecipientsException(String message)
	{
		super(message);
	}

	public NoRecipientsException(Throwable cause)
	{
		super(cause);
	}

	public NoRecipientsException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
