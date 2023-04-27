package com.vortex.Controller;

import org.springframework.stereotype.Controller;

@Controller
public class GodController {
/*
        //获取查询对象
        SqlSession sqlSession = DBUtils.getSqlSessionFactory().openSession();

        //获取对应mapper
        GodMapper godMapper = sqlSession.getMapper(GodMapper.class);
        //工具类
        MyUtils utils = new MyUtils();
        int CommitRow = -1;

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("姓名", "godName");
        hashMap.put("职位", "godPosition");
        hashMap.put("尊号", "godMaster");

        switch (action) {

            //查询所有神仙
            case "/SelectGod":
                int pageSize = Integer.parseInt(req.getParameter("pagesize"));//每页显示的条数
                int currentPage = Integer.parseInt(req.getParameter("currentPage"));//当前页数
                int offset = (currentPage - 1) * pageSize;//分页公式
                List<God> GodList = godMapper.SelectGodAll(offset, pageSize);
                out.println(utils.ResultJson(new MyResult(300, "神仙查询成功", GodList)));
                break;

            //添加神仙页面
            case "/AddGod":
                String AddGodJson = req.getReader().readLine();
                God AddGod = JSON.parseObject(AddGodJson, God.class);
                CommitRow = godMapper.AddGod(AddGod);
                sqlSession.commit();
                if (CommitRow > 0) {
                    out.println(utils.ResultJson(new MyResult(361, "神仙添加成功")));
                } else {
                    out.println(utils.ResultJson(new MyResult(362, "神仙添加失败")));
                }
                break;

            //删除神仙
            case "/DeleteGod":
                int DeleteGodId = Integer.parseInt(req.getParameter("godId"));
                CommitRow = godMapper.DeleteGod(DeleteGodId);
                sqlSession.commit();
                if (CommitRow > 0) {
                    out.println(utils.ResultJson(new MyResult(460, "神仙删除成功")));
                } else {
                    out.println(utils.ResultJson(new MyResult(461, "神仙删除失败")));
                }
                break;

            //更新神仙
            case "/UpdateGod":
                String UpdateJson = req.getReader().readLine();
                God UpdateGod = JSON.parseObject(UpdateJson, God.class);
                CommitRow = godMapper.UpdateGod(UpdateGod);
                sqlSession.commit();
                if (CommitRow > 0) {
                    out.println(utils.ResultJson(new MyResult(400, "神仙修改成功")));
                } else {
                    out.println(utils.ResultJson(new MyResult(401, "神仙修改失败")));
                }
                break;

            //获取神仙总数
            case "/GodCount":
                int count = godMapper.SelectGodCount();
                out.println(utils.ResultJson(new MyResult(301,"神仙总数查询成功",count)));
                break;

            //根据条件查询神仙
            case "/SelectGodForType":
                String search = req.getReader().readLine();
                JSONObject obj = JSONObject.parseObject(search);
                //每页显示的条数
                int searchPageSize = (Integer) obj.get("searchPageSize");
                //当前页数
                int searchCurrentPage = (Integer) obj.get("searchCurrentPage");
                int searchOffset = (searchCurrentPage - 1) * searchPageSize;//分页公式
                String searchType = String.valueOf(obj.get("type"));
                String searchValue = String.valueOf(obj.get("value"));
                List<God> godList = godMapper.SelectGodForType(searchType,searchValue,searchOffset,searchPageSize);
                System.out.println(godList);






//                List<God> godList = godMapper.SelectGodForType(type,searchValue);
//                out.println(utils.ResultJson(new MyResult(999, null, godList)));
                break;
        }
    }
 */
}
