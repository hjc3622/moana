package lab.io.rush.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import lab.io.rush.model.SnapRecord;
import lab.io.rush.repository.SnapRecordRepository;

@Service("snapRecordService")
public class SnapRecordServiceImp implements SnapRecordService{

	@Autowired
	private SnapRecordRepository snapRecordRepository;
	
	@Override
	public void insert(SnapRecord snapRecord) {
		// TODO Auto-generated method stub
		snapRecordRepository.save(snapRecord);
	}

	@Override
	public boolean update(SnapRecord snapRecord) {
		// TODO Auto-generated method stub
		SnapRecord sRecord = snapRecordRepository.findOne(snapRecord.getId());
		if(sRecord==null)
		return false;
		else{
			if(snapRecord.getNum()>=0)
				sRecord.setNum(snapRecord.getNum());
			 return true;
		}
	}

	@Override
	public boolean canTouch(int userId, int moiveId) {
		
		List<SnapRecord> list = snapRecordRepository.selectByUidAndMovieId(userId, moiveId);
		if(list.size()>=2)
		{return false;}
		else 
		{	return true;}
	}

}
