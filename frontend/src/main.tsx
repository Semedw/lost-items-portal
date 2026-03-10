import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { CssBaseline, Box } from "@mui/material";
import "./index.css";
import Navbar from "./components/Navbar";
import AllPosts from "./pages/AllPosts";
import Create from "./pages/Create";
import Edit from "./pages/Edit";

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <BrowserRouter>
      <CssBaseline />
      <Navbar />
      <Box
        sx={{
          width: "100%",
          minHeight: "calc(100vh - 64px)",
        }}
      >
        <Routes>
          <Route path="/" element={<AllPosts />} />
          <Route path="/create" element={<Create />} />
          <Route path="/edit" element={<Edit />} />
        </Routes>
      </Box>
    </BrowserRouter>
  </StrictMode>,
);
