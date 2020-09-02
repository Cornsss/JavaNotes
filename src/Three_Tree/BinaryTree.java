package Three_Tree;

import sun.misc.Queue;

public class BinaryTree<Key extends Comparable<Key>,Value> {
    public int length;
    public BinaryNode root;

    /**
     * 插入键值对
     * @param key
     * @param value
     */
    public void put(Key key, Value value){
        root = this.put(root,key,value);
    }

    /**
     * 指定x树中插入键值对
     * @param x
     * @param key
     * @param value
     */
    public BinaryNode put(BinaryNode x,Key key, Value value){
        //如果x为空，则根节点即为key-value
        if(x == null){
            length++;
            return new BinaryNode(null,null,key,value);
        }

        //如果x不为空，判断key与root.key的大小，

        //key < root.key
        if (key.compareTo((Key) x.key) < 0){
            x.left = put(x.left,key,value);
        }
        //key > root.key
        if (key.compareTo((Key) x.key) > 0){
            x.right = put(x.right,key,value);
        }

        if (key.compareTo((Key) x.key) == 0){
            x.value = value;
        }
        return x;
    }

    /**
     * 获取指定key的元素
     * @param key
     * @return
     */
    public Value get(Key key){
        return get(root,key);
    }

    /**
     * 获取指定二叉树的元素
     * @param x
     * @param key
     * @return
     */
    public Value get(BinaryNode x,Key key){
        //如果x为空，直接返回空
        if (x == null){
            return null;
        }
        if (key.compareTo((Key) x.key) < 0){
            return get(x.left,key);
        }
        //key > root.key
        if (key.compareTo((Key) x.key) > 0){
            return get(x.right,key);
        }

        if (key.compareTo((Key) x.key) == 0){
            return (Value) x.value;
        }
        return null;
    }

    /**
     * 删除元素
     * @param key
     */
    public void delete(Key key){
        delete(root,key);
    }

    /**
     * 删除指定二叉树的元素
     * @param x
     * @param key
     * @return
     */
    public BinaryNode delete (BinaryNode x,Key key){
        //如果x为空
        if (x == null){
            return null;
        }
        //key < root.key
        if (key.compareTo((Key) x.key) < 0){
            x.left = delete(x.left,key);
        }
        //key > root.key
        if (key.compareTo((Key) x.key) > 0){
            x.right = delete(x.right,key);
        }
        //key = root.key
        if (key.compareTo((Key) x.key) == 0){
            //1.找到右子树中最小的结点
            //1.1 如果右子树为空
            if(x.right == null){
                return x.left;
            }
            //1.2 左子树为空
            if (x.left == null){
                return x.right;
            }
            //1.3 左右子树都不为空:找到最小的结点并删除
            BinaryNode minNode = x.right;
            while (minNode.left != null){
                minNode = minNode.left;
            }
            //2.找到最小结点的上一个节点并删除最小节点
            BinaryNode node =  x.right;
            while (node.left != null){
                if(node.left.left == null)
                    node.left = null;
                else
                    node = node.left;
            }
            //让x结点的左子树成为minnode的左子树
            minNode.left = x.left;
            //让x结点的右子树成为minnode的右子树
            minNode.right = x.right;
            //让x的父结点指向minnode
            x = minNode;
        }
        length --;
        return x;
    }

    /**
     * 返回二叉树结点个数
     * @return
     */
    public int size(){
        return length;
    }

    /**
     * 查找树中最小的键
     */
    public Key getMinKey(){
        return (Key) getMinKey(root).key;
    }
    public BinaryNode getMinKey(BinaryNode x){
        if (x == null)
            return null;
        if(x.left != null){
            return getMinKey(x.left);
        }
        return x;
    }

    /**
     * 查找树中最大的键
     */
    public Key getMaxKey(){
        return (Key) getMaxKey(root).key;
    }
    public BinaryNode getMaxKey(BinaryNode x){
        if (x == null)
            return null;
        if(x.right != null){
            return getMaxKey(x.right);
        }
        return x;
    }

    /**
     * 二叉树的前序遍历
     * @return
     */
    public Queue<Key> preErgodic(){
        Queue<Key> keys = new Queue<Key>();
        this.preErgodic(root,keys);
        return keys;
    }

    /**
     * 二叉树的前序遍历
     * @return
     */
    public void preErgodic(BinaryNode x,Queue<Key> keys){
        //1.判断根结点是否为空，为空直接返回null
        if(x == null){
            return;
        }
        keys.enqueue((Key) x.key);
        //2.如果左子树不为空，则递归调用前序遍历
        if(x.left != null){
            preErgodic(x.left,keys);
        }
        //3.如果右子树不为空，则递归调用前序遍历
        if(x.right != null){
            preErgodic(x.right,keys);
        }
    }

    /**
     * 二叉树的中序遍历
     * @return
     */
    public Queue<Key> midErgodic(){
        Queue<Key> keys = new Queue<Key>();
        this.midErgodic(root,keys);
        return keys;
    }

    /**
     * 二叉树的中序遍历
     * @return
     */
    public void midErgodic(BinaryNode x,Queue<Key> keys){
        //1.判断根结点是否为空，为空直接返回null
        if(x == null){
            return;
        }
        //2.先递归，把根节点的所有左子树存入keys
        if(x.left != null){
            midErgodic(x.left,keys);
        }
        //3.存入根节点
        keys.enqueue((Key) x.key);
        //4.递归存入所有右子树
        if(x.right != null){
            midErgodic(x.right,keys);
        }
    }
}
