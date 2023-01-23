package com.nextree.nxboard.repo;

import com.nextree.nxboard.domian.sdo.BookmarkCdo;

public interface UserStore {
  void registerBookmark(BookmarkCdo bookmarkCdo);
}
