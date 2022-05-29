/*
 * Ms.萌森工作室 Copyright (c) 2022. Java基本工具开发由萌森工作室倾情打造，请勿恶意转载！
 */

package io.github.qyg2297248353.utils.tree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 树状数据
 *
 * @author Ms
 */
public class TreeUtils {
    public Map<String, Object> mapArray = new LinkedHashMap<String, Object>();
    public List<Object> menuCommon;
    public List<Object> list = new ArrayList<Object>();

    public static List treeMenuList(List menu, TreeUtilsImpl impl) {
        return new TreeUtils().treeMenu(menu, impl);
    }


    public List treeMenu(List menu, TreeUtilsImpl impl) {
        menuCommon = menu;
        for (Object treeNode : menu) {
            Map<String, Object> mapArr = new LinkedHashMap<String, Object>();
            boolean parent = impl.equalsParent(treeNode);
            if (parent) {
                setTreeMap(mapArr, treeNode, impl);
                list.add(mapArr);
            }
        }
        return list;
    }

    public List<?> menuChild(String id, TreeUtilsImpl impl) {
        List<Object> lists = new ArrayList<Object>();
        for (Object a : menuCommon) {
            Map<String, Object> childArray = new LinkedHashMap<String, Object>();
            String parent = impl.getParentId(a);
            if (parent.equals(id)) {
                setTreeMap(childArray, a, impl);
                lists.add(childArray);
            }
        }
        return lists;
    }

    private void setTreeMap(Map<String, Object> mapArr, Object treeNode, TreeUtilsImpl impl) {
        impl.mapArrAdd(mapArr, treeNode);

        String id = impl.getId(treeNode);
        List<?> children = menuChild(id, impl);
        if (children.size() > 0) {
            mapArr.put("hasChild", true);
        } else {
            mapArr.put("hasChildren", false);
        }
        String childrenName = impl.getChildrenFiledName();
        mapArr.put(childrenName, menuChild(id, impl));
    }

    public interface TreeUtilsImpl {
        /**
         * 父类Id效验
         *
         * @param object 遍历数据
         * @return 是否为父组件
         */
        boolean equalsParent(Object object);

        /**
         * 获取Id
         *
         * @param object 遍历数据
         * @return 当前Id
         */
        String getId(Object object);

        /**
         * 获取父类Id
         *
         * @param object 遍历数据
         * @return 当前父类Id
         */
        String getParentId(Object object);

        /**
         * 数据装填[根据数据放入指定字段数据]
         *
         * @param map    k,v 数据遍历存放
         * @param object 遍历数据
         */
        void mapArrAdd(Map<String, Object> map, Object object);

        /**
         * 配置子类字段名称
         *
         * @return 子类字段名称
         */
        String getChildrenFiledName();
    }
}