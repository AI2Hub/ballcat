package com.hccake.ballcat.notify.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.hccake.ballcat.common.model.entity.LogicDeletedBaseEntity;
import com.hccake.ballcat.notify.enums.AnnouncementStatusEnum;
import com.hccake.ballcat.notify.enums.NotifyChannelEnum;
import com.hccake.ballcat.notify.enums.NotifyRecipientFilterTypeEnum;
import com.hccake.extend.mybatis.plus.alias.TableAlias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 公告信息
 *
 * @author hccake 2020-12-15 17:01:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableAlias(Announcement.TABLE_ALIAS)
@TableName(value = "notify_announcement", autoResultMap = true)
@ApiModel(value = "公告信息")
public class Announcement extends LogicDeletedBaseEntity {

	private static final long serialVersionUID = 1L;

	public static final String TABLE_ALIAS = "a";

	/**
	 * ID
	 */
	@TableId
	@ApiModelProperty(value = "ID")
	private Long id;

	/**
	 * 标题
	 */
	@ApiModelProperty(value = "标题")
	private String title;

	/**
	 * 内容
	 */
	@ApiModelProperty(value = "内容")
	private String content;

	/**
	 * 接收人筛选方式
	 * @see NotifyRecipientFilterTypeEnum
	 */
	@ApiModelProperty(value = "接收人筛选方式")
	private Integer recipientFilterType;

	/**
	 * 对应接收人筛选方式的条件信息，多个用逗号分割。如角色标识，组织ID，用户类型，用户ID等
	 */
	@ApiModelProperty(value = "对应接收人筛选方式的条件信息。如角色标识，组织ID，用户类型，用户ID等")
	@TableField(typeHandler = JacksonTypeHandler.class)
	private List<Object> recipientFilterCondition;

	/**
	 * 接收方式，值与通知渠道一一对应
	 * @see NotifyChannelEnum
	 */
	@ApiModelProperty(value = "接收方式")
	@TableField(typeHandler = JacksonTypeHandler.class)
	private List<Integer> receiveMode;

	/**
	 * 状态
	 * @see AnnouncementStatusEnum
	 */
	@ApiModelProperty(value = "状态")
	private Integer status;

	/**
	 * 永久有效的
	 * @see com.hccake.ballcat.common.core.constant.enums.BooleanEnum
	 */
	@ApiModelProperty(value = "永久有效的")
	private Integer immortal;

	/**
	 * 截止日期
	 */
	@ApiModelProperty(value = "截止日期")
	private LocalDateTime deadline;

}
