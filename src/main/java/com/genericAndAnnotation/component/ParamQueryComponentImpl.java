/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.genericAndAnnotation.component;

import com.genericAndAnnotation.model.ComparableParamModel;
import com.genericAndAnnotation.model.ParamModel;
import com.genericAndAnnotation.model.ParamQueryRequest;
import com.genericAndAnnotation.model.vo.ParmRowVO;
import com.genericAndAnnotation.util.ParamConvertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author wb-fyw404615
 * @version $Id: ParamQueryComponentImpl.java, v 0.1 2019年03月27日 11:03 wb-fyw404615 Exp $
 */
public class ParamQueryComponentImpl implements ParamQueryComponent {

    @Override
    public <T extends ParamModel> T queryUniqueParam(ParamQueryRequest<T> request) throws Exception {

        List<T> paramVOs =  queryParams(request);
        if (CollectionUtils.isEmpty(paramVOs)){
            return null;
        }

        return paramVOs.iterator().next();
    }

    @Override
    public <T extends ParamModel> List<T> queryParams(ParamQueryRequest<T> request) throws Exception {
        String  templateCode = request.getParamTpCode();
        final Map<String,String> conditions = ParamConvertUtil.convertRequest(request);

        List<ParmRowVO> parmRowVOs = new ArrayList<>();
        ParmRowVO parmRowVO = new ParmRowVO();
        parmRowVO.setKey("instIpRoleId");
        Map<String, String> map = new HashMap<>();
        map.put("instIpRoleId","instIpRoleId");
        map.put("chInfo","chInfo");
        parmRowVO.setData(map);
        parmRowVOs.add(parmRowVO);

        if (conditions != null && !conditions.isEmpty()){
            final Set<String> condiSet = conditions.keySet();
            parmRowVOs = parmRowVOs.stream().filter(p -> {
                for (String key : condiSet){
                    String paramVal = ParamConvertUtil.getStringValue(p,key);
                    String condiVal = conditions.get(key);
                    if (!StringUtils.equals(condiVal, paramVal)) {
                        return false;
                    }
                }
                return true;
            }).collect(Collectors.toList());
        }

        if (CollectionUtils.isEmpty(parmRowVOs)){
            return Collections.emptyList();
        }

        List<T> result = new ArrayList<T>();
        for (ParmRowVO v : parmRowVOs) {
            result.add(ParamConvertUtil.convertResult(request.newInstance(), v));
        }

        result.sort((T p1, T p2) -> {
            if (p1 instanceof ComparableParamModel && p2 instanceof ComparableParamModel){
                return ((ComparableParamModel) p1).compareTo((ComparableParamModel) p2);
            }
            return 0;
        });

        return result;
    }
}