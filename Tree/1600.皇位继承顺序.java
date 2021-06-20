package Tree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1600 lang=java
 *
 * [1600] 皇位继承顺序
 * 本题实际上是多叉树的前序遍历, 因此需要写一个多叉树节点, 在birth()时添加增加节点, 在death()时做好标记, 在getInheritanceOrder()时进行前序遍历
 * 为了在birth()时快速找到父亲节点, 使用一个哈希表存储每一个节点
 */

// @lc code=start
class ThroneInheritance {
    private KingdomMumber root;
    private Map<String, KingdomMumber> members;

    public ThroneInheritance(String kingName) {
        root = new KingdomMumber(kingName);
        members = new HashMap<>();
        members.put(kingName, root);
    }
    
    public void birth(String parentName, String childName) {
        KingdomMumber parent = members.get(parentName);
        KingdomMumber child = new KingdomMumber(childName);
        if(parent.children == null){
            List<KingdomMumber> list = new ArrayList<>();
            list.add(child);
            parent.children = list;
        }
        else{
            parent.children.add(child);
        }
        members.put(childName, child);
    }
    
    public void death(String name) {
        members.get(name).isdead = true;
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        preOrderVisit(root, order);
        return order;
    }

    public void preOrderVisit(KingdomMumber root, List<String> res){
        if(root == null)return;

        if(!root.isdead)res.add(root.name);

        if(root.children != null){
            for(KingdomMumber member : root.children){
                preOrderVisit(member, res);
            }
        }
    }

    //多叉树的节点
    class KingdomMumber{
        public String name;
        public boolean isdead;
        public List<KingdomMumber> children;

        public KingdomMumber(String name){
            this.name = name;
            this.isdead = false;
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
// @lc code=end

