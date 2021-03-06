// $Id: PnfsDeleteEntryMessage.java,v 1.3 2005-01-14 13:56:25 tigran Exp $

package diskCacheV111.vehicles;

import java.util.EnumSet;
import java.util.Set;

import diskCacheV111.util.PnfsId;

import org.dcache.namespace.FileType;

public class PnfsDeleteEntryMessage extends PnfsMessage
{
    private static final long serialVersionUID = 7375207858020099787L;

    /**
     * Allowed FileTypes to delete. If the entry is not of this type,
     * then the operation will fail.
     */
    private final Set<FileType> _allowed;

    public PnfsDeleteEntryMessage(String path)
    {
        this(null, path, EnumSet.allOf(FileType.class));
    }

    public PnfsDeleteEntryMessage(String path, Set<FileType> allowed)
    {
        this(null, path, allowed);
    }

    public PnfsDeleteEntryMessage(PnfsId pnfsId, String path,
                                  Set<FileType> allowed)
    {
        super(pnfsId);
        _allowed = allowed;
        setPnfsPath(path);
        setReplyRequired(false);
    }

    public Set<FileType> getAllowedFileTypes()
    {
        return (_allowed == null) ? EnumSet.allOf(FileType.class) : _allowed;
    }
}
