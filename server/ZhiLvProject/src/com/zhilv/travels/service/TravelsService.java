package com.zhilv.travels.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.zhilv.entity.Img;
import com.zhilv.entity.MoreDetail;
import com.zhilv.entity.Travels;
import com.zhilv.travels.dao.TravelsMapper;

/**   
 * @ClassName: TravelsService   
 * @Description:TODO
 * @author: 张璐婷
 * @date: 2021年1月20日 下午5:08:38       
 */
@Service
public class TravelsService {
	
	@Resource
	private TravelsMapper travelsMapper;
	
	/**
	 * @Title: addAuditTravels
	 * @Description: 添加发布版游记
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午6:36:34
	 */
	public int addTravels(Travels travels) {
		return travelsMapper.addTravels(travels);
	}
	
	/**
	 * @Title: addTravelsImg
	 * @Description: 添加图片
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午7:03:40
	 */
	public int addTravelsImg(List<Img> imgs) {
		return travelsMapper.addTravelsImg(imgs);
	}
	
	/**
	 * @Title: addTravelsDetail
	 * @Description: 添加详细信息
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午7:04:58
	 */
	public int addTravelsDetail(MoreDetail moreDetail) {
		return travelsMapper.addTravelsDetail(moreDetail);
	}
	
	/**
	 * @Title: updateDetailTravelsIdById
	 * @Description: 更新详情的travel_id
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午8:48:59
	 */
	public int updateDetailTravelsIdById(Integer travelsId,Integer moreId) {
		return travelsMapper.updateDetailTravelsIdById(travelsId, moreId);
	}
	
	/**
	 * @Title: updateTravelsById
	 * @Description: 更新游记
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午8:24:39
	 */
	public int updateTravelsById(Travels travels) {
		return travelsMapper.updateTravelsById(travels);
	}
	
	/**
	 * @Title: findImgByTravelsId
	 * @Description: 根据travelsId查找图片
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午9:07:05
	 */
	public List<Img> findImgByTravelsId(Integer travelsId){
		return travelsMapper.findImgByTravelsId(travelsId);
	}
	
	/**
	 * @Title: deleteImgById
	 * @Description: 根据ID值删除指定图片
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午8:24:43
	 */
	public int deleteImgById(Integer imgId) {
		return travelsMapper.deleteImgById(imgId);
	}
	
	/**
	 * @Title: updateTravelsDetail
	 * @Description: 更新详情
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午8:24:47
	 */
	public int updateTravelsDetail(MoreDetail moreDetail) {
		return travelsMapper.updateTravelsDetail(moreDetail);
	}
	
	/**
	 * @Title: findAllTravels
	 * @Description: 查询所有发布版游记
	 * @author: 张璐婷 
	 * @date: 2021年1月19日 下午7:57:52
	 */
	public List<Travels> findAllTravels(){
		return travelsMapper.findAllTravels();
	}
	
	/**
	 * @Title: findTravelsByStr
	 * @Description: 根据字符串模糊查询相应travels
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 上午11:46:18
	 */
	public List<Travels> findTravelsByStr(String str){
		return travelsMapper.findTravelsByStr(str);
	}
	
	/**
	 * @Title: findTravelsById
	 * @Description: 根据ID值查询游记
	 * @author: 张璐婷 
	 * @date: 2021年1月20日 下午5:40:58
	 */
	public Travels findTravelsById(Integer travelsId) {
		return travelsMapper.findTravelsById(travelsId);
	}

	/**
	 * @Title: deleteTravelsById
	 * @Description: 根据ID值删除游记
	 * @author: 张璐婷 
	 * @date: 2021年1月22日 下午6:16:45
	 */
	public int deleteTravelsById(Integer travelsId) {
		return travelsMapper.deleteTravelsById(travelsId);
	}
	
	/**
	 * @Title: deleteDetailByTravelsId
	 * @Description: 删除详细信息
	 * @author: 张璐婷 
	 * @date: 2021年1月26日 上午11:37:16
	 */
	public int deleteDetailByTravelsId(Integer travelsId) {
		return travelsMapper.deleteDetailByTravelsId(travelsId);
	}
	
	/**
	 * @Title: deleteImgByTravelsId
	 * @Description: 删除图片
	 * @author: 张璐婷 
	 * @date: 2021年1月26日 上午11:37:12
	 */
	public int deleteImgByTravelsId(Integer travelsId) {
		return travelsMapper.deleteImgByTravelsId(travelsId);
	}
}
