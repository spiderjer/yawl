/*
 * Created on 09/10/2003
 * YAWLEditor v1.0 
 *
 * @author Lindsay Bradford
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package au.edu.qut.yawl.editor.foundations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileUtilities {

  // Generic File Utilities

  /**
   * Moves one file to another. Note that if a file already exists with the same
   * name as <code>targetFile</code> this method will overwrite its contents.
   * @param sourceFile
   * @param targetFile
   * @throws IOException
   */
  public static void move(String sourceFile, String targetFile) throws IOException {
    copy(sourceFile, targetFile);
    new File(sourceFile).delete();
  }
  
  /**
   * Copies one file to another. Note that if a file already exists with the same
   * name as <code>targetFile</code> this method will overwrite its contents.
   * @param sourceFile
   * @param targetFile
   * @throws IOException
   */
  public static void copy(String sourceFile, String targetFile) throws IOException {
    FileChannel sourceChannel = new FileInputStream(sourceFile).getChannel();
    FileChannel targetChannel = new FileOutputStream(targetFile).getChannel();

    targetChannel.transferFrom(sourceChannel, 0, sourceChannel.size());

    sourceChannel.close();
    targetChannel.close();
  }

  /**
   * Strips the extension from a filename, assuming that extensions follow the
   * standard convention of being the text following the last '.' character
   * in the filemane.
   * @param fileName
   * @return The filename sans its extension
   */
  
  public static String stripFileExtension(String fileName) {
    return fileName.substring(
       0, 
       fileName.lastIndexOf('.') 
    );
  }
  
  // Basic Plugin Detail
  
  private static final String USER_DIRECTORY = System.getProperty("user.dir");

  private static final String RELATIVE_PLUGIN_PATH = "YAWLEditorPlugins";

  public static final String ABSOLUTE_PLUGIN_DIRECTORY = 
    USER_DIRECTORY + 
    System.getProperty("file.separator") + 
    RELATIVE_PLUGIN_PATH;

  // Task Icon Plugin Utilities
  
  private static final String TASK_ICON_PATH = "TaskIcons";

  private static final String RELATIVE_TASK_ICON_PATH = 
    RELATIVE_PLUGIN_PATH +
    System.getProperty("file.separator") + 
    TASK_ICON_PATH;
  
  public static final String ABSOLUTE_TASK_ICON_PATH = 
    USER_DIRECTORY + 
    System.getProperty("file.separator") + 
    RELATIVE_TASK_ICON_PATH;

  /**
   * Given the relative path of an icon, returns the absolute path
   * where it will be found in the current environment.
   * @param relativeIconPath
   * @return
   */
  public static String getAbsoluteTaskIconPath(String relativeIconPath) {
    return ABSOLUTE_TASK_ICON_PATH + 
           System.getProperty("file.separator") + 
           relativeIconPath;
  }
  
  /**
   * Given the absolte path of an icon, returns just the relative 
   * path to the icon that is independant of the absolute task icon plugin path.
   * @param absoluteIconPath
   * @return
   */
  
  public static String getRelativeTaskIconPath(String absoluteIconPath) {
    assert absoluteIconPath.startsWith(
        ABSOLUTE_TASK_ICON_PATH + 
        System.getProperty("file.separator")
    );

    return absoluteIconPath.substring(
      (ABSOLUTE_TASK_ICON_PATH + System.getProperty("file.separator")).length()    
    );
  }
  
  // Extended Attribute Plugin Utilities
  
  private static final String EXTENDED_ATTRIBUTE_PATH = "ExtendedAttributeProperties";
  private static final String DECOMPOSITION_EXTENDED_ATTRIBUTE_PROPERTIES = "DecompositionProperties";
  private static final String VARIABLE_EXTENDED_ATTRIBUTE_PROPERTIES = "VariableProperties";
  
  private static final String RELATIVE_EXTENDED_ATTRIBUTE_PATH = 
    RELATIVE_PLUGIN_PATH +
    System.getProperty("file.separator") + 
    EXTENDED_ATTRIBUTE_PATH;

  public static final String ABSOLUTE_EXTENDED_ATTRIBUTE_PATH = 
    USER_DIRECTORY + 
    System.getProperty("file.separator") + 
    RELATIVE_EXTENDED_ATTRIBUTE_PATH;

  /**
   * Returns the absolute path of the decomposition extended attribute properties plugin file
   * @param relativeIconPath
   * @return
   */
  public static String getDecompositionPropertiesExtendeAttributePath() {
    return ABSOLUTE_EXTENDED_ATTRIBUTE_PATH + 
           System.getProperty("file.separator") + 
           DECOMPOSITION_EXTENDED_ATTRIBUTE_PROPERTIES;
  }

  /**
   * Returns the absolute path of the variable extended attribute properties plugin file
   * @param relativeIconPath
   * @return
   */
  public static String getVariablePropertiesExtendedAttributePath() {
    return ABSOLUTE_EXTENDED_ATTRIBUTE_PATH + 
           System.getProperty("file.separator") + 
           VARIABLE_EXTENDED_ATTRIBUTE_PROPERTIES;
  }
}