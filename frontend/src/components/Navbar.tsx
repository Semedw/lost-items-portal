import { AppBar, Toolbar, Typography, Button, Box } from "@mui/material";
import { Package, Plus, List } from "lucide-react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <AppBar position="sticky" sx={{ top: 0, zIndex: 1100 }}>
      <Toolbar>
        <Package style={{ marginRight: "12px" }} />
        <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          Campus Lost Item Reporter
        </Typography>
        <Box sx={{ display: "flex", gap: 1 }}>
          <Button
            color="inherit"
            component={Link}
            to="/"
            startIcon={<List size={20} />}
          >
            All Posts
          </Button>
          <Button
            color="inherit"
            component={Link}
            to="/create"
            startIcon={<Plus size={20} />}
          >
            Report Lost Item
          </Button>
        </Box>
      </Toolbar>
    </AppBar>
  );
};

export default Navbar;
