import util.TreeNode;

class BloombergIsValidBST {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }

        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        } else {
            return validate(root.left, low, root.val) && validate(root.right, root.val, high);
        }
    }

    Integer prev = null;

    public boolean isValidBST2(TreeNode root) {
        return traverse(root);
    }

    public boolean traverse(TreeNode root) {
        if (root == null) return true;

        if (!traverse(root.left)) return false;

        if (prev != null && prev > root.val) return false;

        prev = root.val;
        return traverse(root.right);
    }

}