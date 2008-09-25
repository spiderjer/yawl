// Copyright 2005 Chibacon
/*
 *
 * Artistic License
 *
 * Preamble
 *
 * The intent of this document is to state the conditions under which a
 * Package may be copied, such that the Copyright Holder maintains some
 * semblance of artistic control over the development of the package, while
 * giving the users of the package the right to use and distribute the
 * Package in a more-or-less customary fashion, plus the right to make
 * reasonable modifications.
 *
 * Definitions:
 *
 * "Package" refers to the collection of files distributed by the Copyright
 * Holder, and derivatives of that collection of files created through
 * textual modification.
 *
 * "Standard Version" refers to such a Package if it has not been modified,
 * or has been modified in accordance with the wishes of the Copyright
 * Holder.
 *
 * "Copyright Holder" is whoever is named in the copyright or copyrights
 * for the package.
 *
 * "You" is you, if you're thinking about copying or distributing this
 * Package.
 *
 * "Reasonable copying fee" is whatever you can justify on the basis of
 * media cost, duplication charges, time of people involved, and so
 * on. (You will not be required to justify it to the Copyright Holder, but
 * only to the computing community at large as a market that must bear the
 * fee.)
 *
 * "Freely Available" means that no fee is charged for the item itself,
 * though there may be fees involved in handling the item. It also means
 * that recipients of the item may redistribute it under the same
 * conditions they received it.
 *
 * 1. You may make and give away verbatim copies of the source form of the
 *    Standard Version of this Package without restriction, provided that
 *    you duplicate all of the original copyright notices and associated
 *    disclaimers.
 *
 * 2. You may apply bug fixes, portability fixes and other modifications
 *    derived from the Public Domain or from the Copyright Holder. A
 *    Package modified in such a way shall still be considered the Standard
 *    Version.
 *
 * 3. You may otherwise modify your copy of this Package in any way,
 *    provided that you insert a prominent notice in each changed file
 *    stating how and when you changed that file, and provided that you do
 *    at least ONE of the following:
 *
 *    a) place your modifications in the Public Domain or otherwise make
 *    them Freely Available, such as by posting said modifications to
 *    Usenet * or an equivalent medium, or placing the modifications on a
 *    major * archive site such as ftp.uu.net, or by allowing the Copyright
 *    Holder * to include your modifications in the Standard Version of the
 *    Package.
 *
 *    b) use the modified Package only within your corporation or *
 *    organization.
 *
 *    c) rename any non-standard executables so the names do not conflict
 *    with standard executables, which must also be provided, and provide a
 *    separate manual page for each non-standard executable that clearly
 *    documents how it differs from the Standard Version.
 *
 *    d) make other distribution arrangements with the Copyright Holder.
 *
 * 4. You may distribute the programs of this Package in object code or
 *    executable form, provided that you do at least ONE of the following:
 *
 *    a) distribute a Standard Version of the executables and library
 *    files, together with instructions (in the manual page or equivalent)
 *    on where to get the Standard Version.
 *
 *    b) accompany the distribution with the machine-readable source of the
 *    Package with your modifications.
 *
 *    c) accompany any non-standard executables with their corresponding
 *    Standard Version executables, giving the non-standard executables
 *    non-standard names, and clearly documenting the differences in manual
 *    pages (or equivalent), together with instructions on where to get the
 *    Standard Version.
 *
 *    d) make other distribution arrangements with the Copyright Holder.
 *
 * 5. You may charge a reasonable copying fee for any distribution of this
 *    Package. You may charge any fee you choose for support of this
 *    Package. You may not charge a fee for this Package itself.  However,
 *    you may distribute this Package in aggregate with other (possibly
 *    commercial) programs as part of a larger (possibly commercial)
 *    software distribution provided that you do not advertise this Package
 *    as a product of your own.
 *
 * 6. The scripts and library files supplied as input to or produced as
 *    output from the programs of this Package do not automatically fall
 *    under * the copyright of this Package, but belong to whomever
 *    generated them, * and may be sold commercially, and may be aggregated
 *    with this Package.
 *
 * 7. C or perl subroutines supplied by you and linked into this Package
 *    shall not be considered part of this Package.
 *
 * 8. The name of the Copyright Holder may not be used to endorse or
 *    promote products derived from this software without specific prior *
 *    written permission.
 *
 * 9. THIS PACKAGE IS PROVIDED "AS IS" AND WITHOUT ANY EXPRESS OR IMPLIED
 *    WARRANTIES, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTIES OF
 *    MERCHANTIBILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 *
 */
package org.chiba.web.servlet;

import org.apache.log4j.xml.DOMConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Initialization servlet for the log4j system.  should be loaded on tomcat
 * start.
 *
 * @author <a href="mailto:gregor@eyestep.org">Gregor Klinke</a>
 * @version $Id: Log4jInit.java,v 1.1 2006/09/10 19:50:51 joernt Exp $
 */
public class Log4jInit extends HttpServlet {
    /**
     * __UNDOCUMENTED__
     *
     * @param req  __UNDOCUMENTED__
     * @param resp __UNDOCUMENTED__
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        /* nop - this servlet is used only for log4j initialization */
    }

    /**
     * __UNDOCUMENTED__
     *
     * @throws ServletException __UNDOCUMENTED__
     */
    public void init() throws ServletException {
        String file = getInitParameter("log4j-init-file");
        String path = getServletContext().getRealPath(file.startsWith("/")
                ? file
                : ("/" + file));

        if (path != null) {
            DOMConfigurator.configure(path);
        }
    }
}


/*
   $Log: Log4jInit.java,v $
   Revision 1.1  2006/09/10 19:50:51  joernt
   renamed org.chiba.adapter to org.chiba.web as appropriate.

   Revision 1.1.1.1  2005/05/04 22:01:13  joernt
   no message

   Revision 1.2  2005/02/19 15:37:43  joernt
   changed package name

   Revision 1.1.1.1  2005/02/19 14:56:10  joernt
   no message

   Revision 1.5  2005/01/31 22:49:11  joernt
   added copyright notice

   Revision 1.4  2005/01/31 22:30:20  joernt
   added copyright notice

   Revision 1.3  2004/08/15 14:14:02  joernt
   preparing release...
   -reformatted sources to fix mixture of tabs and spaces
   -optimized imports on all files

   Revision 1.2  2003/10/02 15:15:50  joernt
   applied chiba jalopy settings to whole src tree

   Revision 1.1  2003/07/12 12:13:17  joernt
   package refactoring: moved from servlet package
   Revision 1.2  2003/05/27 17:36:45  unl
   - adapted latest changes from 0.8
   Revision 1.1.1.1  2003/05/23 14:54:06  unl
   no message
   Revision 1.2  2002/07/28 14:49:38  joernt
   big cleanup of unused imports, vars and params; unneeded methods removed.
   Revision 1.1  2001/10/30 14:19:57  gregor
   added for log4jing
 */