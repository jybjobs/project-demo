$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'room/organization/page',
        datatype: "json",
        colModel: [			
			{ label: 'orgId', name: 'orgId', index: 'org_id', width: 50, key: true },
			{ label: '省份', name: 'proId', index: 'pro_id', width: 80 }, 			
			{ label: '市', name: 'cityId', index: 'city_id', width: 80 }, 			
			{ label: '企业名称', name: 'name', index: 'name', width: 80 }, 			
			//{ label: '排序', name: 'orderNum', index: 'order_num', width: 80 },
			//{ label: '是否删除  -1：已删除  0：正常', name: 'delFlag', index: 'del_flag', width: 80 },
			{ label: '企业代码', name: 'code', index: 'code', width: 80 }, 			
			{ label: '详细地址', name: 'adress', index: 'adress', width: 80 }, 			
			{ label: '联系电话', name: 'phone', index: 'phone', width: 80 }, 			
			{ label: '联系人', name: 'attenName', index: 'atten_name', width: 80 }, 			
			{ label: '官网地址', name: 'website', index: 'website', width: 80 }, 			
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
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
            $("#jqGrid").setGridParam().hideCol("orgId");
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
		organization: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
        getOrg: function(){
            $.get(baseURL + "room/area/list", function(r){
                ztree = $.fn.zTree.init($("#orgTree"), setting, r.data);
                var node = ztree.getNodeByParam("areaId", vm.organization.proId);
                ztree.selectNode(node);
                vm.organization.proName = node.name;
            })
        },
        getCity: function(){
            $.get(baseURL + "room/area/list", function(r){
                ztree2 = $.fn.zTree.init($("#cityTree"), setting, r.data);
                var node = ztree2.getNodeByParam("areaId", vm.organization.cityId);
                ztree2.selectNode(node);
                vm.organization.cityName = node.name;
            })
        },
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.organization = {proName:null,cityName:null,proId:1,cityId:1};
            vm.getOrg();
            vm.getCity();
		},
		update: function (event) {
			var orgId = getSelectedRow();
			if(orgId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(orgId)
            vm.getOrg();
		},
		saveOrUpdate: function (event) {
			var url = vm.organization.orgId == null ? "room/organization/save" : "room/organization/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.organization),
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
		del: function (event) {
			var orgIds = getSelectedRows();
			if(orgIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "room/organization/delete",
                    contentType: "application/json",
				    data: JSON.stringify(orgIds),
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
		getInfo: function(orgId){
			$.get(baseURL + "room/organization/info/"+orgId, function(r){
                vm.organization = r.organization;
            });
		},
        orgTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择所在区域",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#orgLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    vm.organization.proId = node[0].areaId;
                    vm.organization.proName = node[0].name;
                    layer.close(index);
                }
            });
        },
        cityTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择所在区域",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#cityLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree2.getSelectedNodes();
                    vm.organization.cityId = node[0].areaId;
                    vm.organization.cityName = node[0].name;
                    layer.close(index);
                }
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