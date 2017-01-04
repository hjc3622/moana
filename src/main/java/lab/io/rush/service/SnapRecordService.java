package lab.io.rush.service;

import lab.io.rush.model.SnapRecord;

public interface SnapRecordService {

	public void insert(SnapRecord snapRecord);
	
	public boolean update(SnapRecord snapRecord);
	
	public boolean canTouch(int userId, int moiveId);
}
