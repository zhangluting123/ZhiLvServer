package com.zhilv.recommend.scene.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.zhilv.entity.Scene;

/**   
 * @ClassName: SceneMapper   
 * @Description:TODO
 * @author: �����
 * @date: 2021��2��8�� ����9:14:43       
 */
public interface SceneMapper {

	/**
	 * @Title: updateScene
	 * @Description: ���¾�����Ϣ
	 * @author: ����� 
	 * @date: 2021��2��8�� ����11:07:45
	 */
	public int updateScene(@Param("scene")Scene scene);
	
	/**
	 * @Title: addSceneUpdateMsg
	 * @Description: ���Ӹ�����Ϣ
	 * @author: ����� 
	 * @date: 2021��2��8�� ����11:08:51
	 */
	public int addSceneUpdateMsg(@Param("userId")Integer userId, @Param("sceneId")Integer sceneId, @Param("updateTime")Date updateTime);

	/**
	 * @Title: findAllScene
	 * @Description: ��ѯ���о���
	 * @author: ����� 
	 * @date: 2021��2��8�� ����12:03:26
	 */
	public List<Scene> findAllScene();
	
	/**
	 * @Title: findSceneByTitle
	 * @Description: ����Ŀ�ĵز�ѯ������ϸ��Ϣ
	 * @author: �����
	 * @date: 2021��2��9�� ����1:06:20
	 */
	public List<Scene> findSceneByTitle(String title);
	
	/**
	 * @Title: findSceneById
	 * @Description: ����IDֵ���Ҿ�����Ϣ
	 * @author: �����
	 * @date: 2021��2��10�� ����3:12:20
	 */
	public Scene findSceneById(Integer sceneId);
}