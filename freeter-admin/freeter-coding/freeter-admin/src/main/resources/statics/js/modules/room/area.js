$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'room/area/page',
        datatype: "json",
        colModel: [
			{ label: '区域ID', name: 'areaId', index: 'area_id',visible: false, width: 50, key: true },
			{ label: '上级ID', name: 'parentId', index: 'parent_id', width: 80 },
			{ label: '区域名称', name: 'name', index: 'name', width: 80 },
			{ label: '排序', name: 'orderNum', index: 'order_num', width: 80 }, 			
		//	{ label: '是否删除  -1：已删除  0：正常', name: 'delFlag', index: 'del_flag', width: 80 },
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount",
            repeatitems : false
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){

            $("#jqGrid").setGridParam().hideCol("parentId");
            $("#jqGrid").setGridParam().hideCol("areaId");

            //隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});
var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "areaId",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    }
};
var ztree;
var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		area: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
        getArea: function(){
            //加载qy树
            $.get(baseURL + "room/area/list", function(r){
                ztree = $.fn.zTree.init($("#areaTree"), setting, r.data);
                var node = ztree.getNodeByParam("areaId", vm.area.parentId);
                ztree.selectNode(node);

                vm.area.parentName = node.name;
            })
        },
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.area = {parentName:null,parentId:1,orderNum:0};
            vm.getArea();
		},
		update: function (event) {
			var areaId = getSelectedRow();
			if(areaId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            // vm.getInfo(areaId)
            // //加载qy树
            // $.get(baseURL + "room/area/list", function(r){
            //     ztree = $.fn.zTree.init($("#areaTree"), setting, r.data);
            //     var node = ztree.getNodeByParam("areaId", vm.area.parentId);
            //     ztree.selectNode(node);
            //     vm.area.parentName = node.name;
            // })
            $.get(baseURL + "room/area/info/"+areaId, function(r){
              //  vm.area = r.area;
                vm.area = {parentName:null,parentId:r.area.parentId,areaId:r.area.areaId,name:r.area.name,orderNum:r.area.orderNum};
                //   vm.area.parentName = .name;
                  vm.getArea();
            });
		},
		saveOrUpdate: function (event) {
			var url = vm.area.areaId == null ? "room/area/save" : "room/area/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.area),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
        areaTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择上级区域",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#areaLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级部门
                    vm.area.parentId = node[0].areaId;
                    vm.area.parentName = node[0].name;

                    layer.close(index);
                }
            });
        },
		del: function (event) {
			var areaIds = getSelectedRows();
			if(areaIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "room/area/delete",
                    contentType: "application/json",
				    data: JSON.stringify(areaIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(areaId){
			$.get(baseURL + "room/area/info/"+areaId, function(r){
                vm.area = r.area;
             //   vm.area.parentName = .name;
              //  vm.getArea();
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});