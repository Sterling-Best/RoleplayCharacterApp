/*********************************************************************
*
*      Copyright (C) 2003 Andrew Khan
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or (at your option) any later version.
*
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
***************************************************************************/

package jexcelapi.src.jxl.read.biff;

import jexcelapi.src.jxl.biff.RecordData;

/**
 * Contains the print grid lines option of this worksheet
 */
class PrintHeadersRecord extends RecordData
{
  /**
   * print grid lines flag
   */
  private boolean printHeaders;

 /**
   * Constructs the value from the raw data
   *
   * @param ph the raw data
   */
  public PrintHeadersRecord(Record ph)
  {
    super(ph);
    byte[] data = ph.getData();

    printHeaders = (data[0] == 1 ? true : false);
  }

  /**
   * Accessor for the print headers flag
   *
   * @return TRUE to print headers, FALSE otherwise
   */
  public boolean getPrintHeaders()
  {
    return printHeaders;
  }

}
